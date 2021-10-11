package edu.uoc.uocleaner.model;

/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Subclass from Sprite.
 * A Wall sprite.
 * Defines the characteristics of the the Wall, 
 */
public class Dirt extends Sprite{
	/** 
	 * Corridors's symbol
	 */
	public Symbol symbol=Symbol.DIRT;
	/**
	 * Points which are added to the vacuum cleaner's capacity.
	 */
	private int score = 1;
	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the corridor element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 */
	public Dirt(int row, int column) throws SpriteException {
		super(row, column, Symbol.DIRT);
		
		
	}
	/**
	 * Second Parameterized constructor
	 * @param row - Index of the row in which the corridor element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @param score - Points of the dirt.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 */
	protected Dirt( int row, int column,  Symbol symbol, int score) throws SpriteException {
		super(row, column, symbol);
		this.score = score;
	}
	
	/**
	 * Getter of score.
	 * @return The value of the score/points of the dirt.
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Setter of score.
	 * @param score - Points to assign to the dirt element.
	 */
	public void setScore(int score) {
		this.score = score;
	}

}