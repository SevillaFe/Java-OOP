package edu.uoc.uocleaner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
 * Level/Room class. 
 * @author David García Solórzano
 * @version 1.0 
 */
public class Level{
	/**
	 * Number of rows of the board.
	 */
	private int numRows;
	/**
	 * Number of columns of the board.
	 */
	private int numColumns;
	/**
	 * Representation of the 2D board.
	 */
	private Sprite[][] board;
	/**
	 * Name of the background image for the GUI app.
	 */
	private String imageBackground;
	/**
	 * Number of turns which the player has in order to beat the level.
	 */
	private int turns;	
	/**
	 * Maximum time which the player has in order to beat the level.
	 */
	private int time;
		
	/**
	 * Constructor 
	 * @param fileName Name of the configuration file which has all the information of the level.
	 * @throws FileNotFoundException When it is impossible to open the configuration file.
	 * @throws LevelException When the number of rows or columns are zero or negative; 
	 * when the number of turns or time is negative; when there is not only one vacuum cleaner; when there are not dumpsters; 
	 * when there are not dirts or dustballs.
	 * @throws VacuumException When the value for the vacuum cleaner's capacity is zero or negative.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Level(String fileName) throws FileNotFoundException, LevelException, VacuumException, SpriteException {
		char[] line = null;
		boolean isDumpster = false, isDirt = false;
		int numVacuums = 0;		
		
		Scanner sc = new Scanner(new File(fileName));

		// find the number of rows and columns       
        setNumRows(Integer.parseInt(sc.nextLine()));
        setNumColumns(Integer.parseInt(sc.nextLine()));
        setImageBackground(sc.nextLine());
        setTurns(Integer.parseInt(sc.nextLine()));
        setTime(Integer.parseInt(sc.nextLine()));
        
        board = new Sprite[numRows][numColumns];           
        for (int row = 0; row < numRows; row++) {
        	line = sc.nextLine().toCharArray();        	
			for (int column = 0; column < numColumns; column++) {				
				board[row][column] = SpriteFactory.getSprite(row,column,Symbol.getName(line[column]));				
				if(board[row][column] instanceof Dirt) isDirt = true;
				if(board[row][column] instanceof Vacuum) numVacuums++;
				if(board[row][column] instanceof Dumpster) isDumpster = true;								
			}			
        }        
        
        sc.close();       
                
        if(numVacuums!=1) {
        	throw new LevelException(LevelException.ERROR_NUM_VACUUMS);
        }
        
        if(!isDumpster) {
        	throw new LevelException(LevelException.ERROR_NO_DUMPSTERS);
        }
        
        if(!isDirt) {
        	throw new LevelException(LevelException.ERROR_NO_DIRT);
        }        
	}	
	
	/**
	 * Getter of numRows.
	 * @return Value of the field "numRows".
	 */
	public int getNumRows() {
		return numRows;
	}
	/**
	 * Getter of numColumns.
	 * @return Value of the field "numColumns".
	 */
	public int getNumColumns() {
		return numColumns;
	}
	/**
	 * Getter of imageBackground.
	 * @return Value of the field "imageBackground".
	 */
	public String getImageBackground() {
		return imageBackground;
	}
	/**
	 * Getter of turns.
	 * @return Value of the field "turns".
	 */
	public int getTurns() {
		return turns;
	}
	/**
	 * Getter of time.
	 * @return Value of the field "time".
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Setter of numRows.
	 * @param numRows - The new value to assign to the field "numRows".
	 * @throws LevelException - When the value of the parameter "numRows" is zero or negative.
	 */
	private void setNumRows(int numRows) throws LevelException{
		try {
			if(numRows<=0) {
				throw new LevelException(LevelException.ERROR_NUM_ROWS_INCORRECT);
			}else {
				this.numRows = numRows;
				}
			}
		catch (Exception e) {
			this.numRows = getNumRows();
			}	
	}
	/**
	 * Setter of numColumns.
	 * @param numColumns - The new value to assign to the field "numColumns".
	 * @throws LevelException - When the value of the parameter "numColumns" is zero or negative.
	 */
	private void setNumColumns(int numColumns) throws LevelException{
		try {
			if(numColumns<=0) {
				throw new VacuumException(LevelException.ERROR_NUM_COLUMNS_INCORRECT);
			}else {
				this.numColumns = numColumns;
				}
			}
		catch (Exception e) {
			this.numColumns = getNumColumns();
			}	
		
	}
	/**
	 * Setter of imageBackground.
	 * @param imageBackground - Value to assign to the field "imageBackground".
	 */
	private void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}
	/**
	 * Setter of turns.
	 * @param turns - Value to assign to the field "turns".
	 * @throws LevelException - When the value of the parameter "turns" is negative.
	 */
	private void setTurns(int turns) throws LevelException{
		try {
			if(turns<0) {
				throw new LevelException(LevelException.ERROR_NUM_TURNS_INCORRECT);
			}else {
				this.turns = turns;
				}
			}
		catch (Exception e) {
			this.turns = getTurns();
			}	
	}
	/**
	 * Setter of time.
	 * @param time - Value to assign to the field "time".
	 * @throws LevelException - When the value of the parameter "time" is negative.
	 */
	private void setTime(int time) throws LevelException{
		try {
			if(time<0) {
				throw new LevelException(LevelException.ERROR_NUM_TIME_INCORRECT);
			}else {
				this.time = time;
				}
			}
		catch (Exception e) {
			this.time = getTime();
			}
	}
	/**
	 * Decreases one unit the value of the filed "turns".
	 * @throws LevelException - When the value of the parameter "turns" is negative.
	 */
	public void decTurns() throws LevelException{
		if(turns-1<0) {
			throw new LevelException(LevelException.ERROR_NUM_TURNS_INCORRECT);
		}else {
			this.turns= turns-1;
		}
	}
	/**
	 * Decreases one unit the value of time.
	 * @throws LevelException - When the value of the parameter "turns" is negative.
	 */
	public void decTime() throws LevelException{
		if(time-1<0) {
			throw new LevelException(LevelException.ERROR_NUM_TIME_INCORRECT);
		}else {
			this.time= time-1;
		}
	} 
	/**
	 * This method returns a 1-D list with all the sprites which are in the board. 
	 * The rows are concatenated in a sequential order.
	 * @return 1-D board in the format of a List.
	 */ 
	public List<Sprite> get1DBoard() {
		
		//return Arrays.stream(board).flatMap(Arrays::stream).collect(Collectors.toCollection(ArrayList::new))
	 		
		List<Sprite> Dim1 = new ArrayList<Sprite>();
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numColumns; j++)
		    {
				Dim1.add(board[i][j]);
			}	    
		}
		return Dim1;
	}
	/**
	 * Given a row, this method analyzes it and put it into the range of [0, maxRow)
	 * @param row - Index to put into the valid range.
	 * @return Index of the row within the valid range.
	 */
	private int putRowInRange(int row) {
		if(row<0) {
			return 0;
		}if (row>numRows-1) {
			return numRows-1;
		}
			return row;	
	}
	/**
	 * Given a column, this method analyzes it and put it into the range of [0, maxColumn)
	 * @param column - Index to put into the valid range.
	 * @return Index of the column within the valid range.
	 */
	private int putColumnInRange(int column) {
		if(column<0) {
			return 0;
		}if (column>this.numColumns) {
			return numColumns-1;
			
		}else {
			return column;
		}
	}
	/**
	 * Retrieve the sprite which is in the cell (row, column).
	 * @return Sprite which is in the cell (row, column).
	 */
	public Sprite getCell(int row, int column) {
		return board[putRowInRange(row)][putColumnInRange(column)]; 
	}
	/**
	 * Sets the "sprite" in the specific cell indicated by sprite's row and column.
	 * @param sprite - Sprite to put into the cell indicated by sprite's row and sprite's column.
	 * @throws SpriteException - When either the row index or the column index are negative.
	 * @throws  
	 * @throws VacuumException 
	 */
	public void setCell(Sprite sprite) throws SpriteException {
		
		board[sprite.getRow()][sprite.getColumn()]=sprite;
	
	}
	/**
	 * Sets the sprite in a specific (row,column) cell. Updates sprite's row and column information with the data of the parameters "row" and "column". 
	 * Likewise, it puts the indexes in range of [0,board.max).
	 * @param row - Index of the row in which the sprite must be.
	 * @param column - Index of the column in which the sprite must be. 
	 * @param sprite - Sprite to put into the (row,column) cell.
	 * @throws SpriteException - When either the row index or the column index are negative.
	 */
	public void setCell(int row, int column, Sprite sprite) throws SpriteException {

		if(sprite.getRow()<0) {
			//this.numRows=sprite.getRow()+1;
			sprite.setRow(row);
		}
		else if(sprite.getColumn()<0) {
			//this.numColumns=column+1;
			sprite.setColumn(column);
		}else {
			sprite.setRow(row);
			sprite.setColumn(column);
			board[sprite.getRow()][sprite.getColumn()]=sprite;
		}
	}
	
	@Override
	public String toString() {

		String aString = "";
	    for(int row = 0; row < numRows; row++) {
	        for(int col = 0; col < numColumns; col++) {
	           aString += "" + board[row][col];
	        }
	           aString += "\n";
	     }
	    return aString;
	}
}