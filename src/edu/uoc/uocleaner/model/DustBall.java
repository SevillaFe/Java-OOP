package edu.uoc.uocleaner.model;

import java.util.ArrayList;
import java.util.Random; 


/**
* @author Fernando Sevilla Martínez
* @version 1.0
*
* Subclass from Sprite.
* A Dustball sprite.
* Defines the characteristics of the the Dustball, 
*/
public class DustBall extends Dirt implements Movable{

	/**
	 * Dustball's symbol
	 */
	public Symbol symbol=Symbol.DUSTBALL;

	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the corridor element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 */
	public DustBall(int row, int column) throws SpriteException {
		super(row, column, Symbol.DUSTBALL, 5);
		//symbol= Symbol.DUSTBALL;
		//this.symbol=Symbol.DUSTBALL;
	}

	/**
	 * {@inheritDoc}
	 * Moves the object to the new row and column position.
	 * @param row - the new row index
	 * @param column - the new column index
	 * @throws SpriteException
	 */
	@Override
	public void moveTo(int row, int column) throws SpriteException {
		this.setRow(row);
		this.setColumn(column);	
	}
	/**
	 * Indicates if the position (row, column) to move in the board is valid for the dustball.
	 * @param level - Object which refers to one level/room of the game.
	 * @param row - Index of the row where the dustball wants to move to.
	 * @param column - Index of the column where the dustball wants to move to.
	 * @return True if the position is valid, otherwise it returns false.
	 */
	private boolean validMove(Level level, int row, int column) {
		if(
			(column<=level.getNumColumns() & row<=level.getNumRows() &&
			level.getCell(row, column).getSymbol().name()!=Symbol.WALL.name() &&
			level.getCell(row, column).getSymbol().name()!=Symbol.VACUUM.name() &&
			level.getCell(row, column).getSymbol().name()!=Symbol.DUSTBALL.name() &&
			level.getCell(row, column).getSymbol().name()!=Symbol.DUMPSTER.name() 
			))
		{	
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Move the dustball randomly to a valid position.
	 * @param level - Object which refers to one level/room of the game.
	 * @return ArrayList with pairs (row-column) that represent the valid moves that the 
	 * dustball can do from its current position.
	 */
	public ArrayList<int[]> moveRandomly(Level level) {

		ArrayList<int[]> arr = new ArrayList<int[]>();
	       arr.add(new int[]{this.getRow()+SPEED,this.getColumn()});
	       arr.add(new int[]{this.getRow()-SPEED,this.getColumn()});
	       arr.add(new int[]{this.getRow(),this.getColumn()+SPEED});
	       arr.add(new int[]{this.getRow(),this.getColumn()-SPEED});
	       
	    ArrayList<int[]> moves = new ArrayList<int[]>();
	       for (int i = 0 ; i<arr.size() ; i++) {
	    		   int[] x= arr.get(i);
	    		   if(validMove(level, x[0], x[1])) {
	    			   moves.add(arr.get(i));
	    		   }
	    		  }
	       Random rand = new Random();
	       double randomNum = 0.05 + ( 1.0 - 0.1 ) * rand.nextDouble();
	       try {
	    	// >0.9 has been chosen to reduce the "speed" of the appearance of dirts
			if(randomNum>0.9) { //it moves
				int randomNum2 = 0 + rand.nextInt(((moves.size()) - 0) + 1); //Random direcction
				switch(randomNum2) { // pick the case
				
				case 1:
					int[] a=moves.get(randomNum2-1); // get the value of Index
					Sprite dirt_a=new Dirt(this.getRow(), this.getColumn()); // Create a dirt		
					moveTo(a[0], a[1]); // Move Dustball to the new position
					Sprite dustball_a=new DustBall(this.getRow(), this.getColumn()); //Create a new dustball
					level.setCell(dirt_a); //Put the new dirt where dustball was
					level.setCell(dustball_a);// Put the new dustball in the new cell
					moves.clear(); // Clear the list
					moves.add(a); // Add only the choosen direction
					break;
				case 2:
					int[] b=moves.get(randomNum2-1);
					Sprite dirt_b=new Dirt(this.getRow(), this.getColumn());
					moveTo(b[0], b[1]);
					Sprite dustball_b=new DustBall(this.getRow(), this.getColumn());
					level.setCell(dirt_b);
					level.setCell(dustball_b);
					moves.clear();
					moves.add(b);
					break;
				case 3:
					int[] c=moves.get(randomNum2-1);
					Sprite dirt_c=new Dirt(this.getRow(), this.getColumn());
					moveTo(c[0], c[1]);
					Sprite dustball_c=new DustBall(this.getRow(), this.getColumn());
					level.setCell(dirt_c);
					level.setCell(dustball_c);
					moves.clear();
					moves.add(c);
					break;
				case 4:
					int[] d=moves.get(randomNum2-1);
					Sprite dirt_d=new Dirt(this.getRow(), this.getColumn());
					moveTo(d[0], d[1]);
					Sprite dustball_d=new DustBall(this.getRow(), this.getColumn());
					level.setCell(dirt_d);
					level.setCell(dustball_d);
					moves.clear();
					moves.add(d);
					break;
				}
			}else
				moveTo(this.getRow(), this.getColumn()); // stay where you were
	       } catch (SpriteException e) {
				e.printStackTrace();
			}
		return moves;
		}
}