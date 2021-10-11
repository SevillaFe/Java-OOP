package edu.uoc.uocleaner.model;

/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Subclass from Sprite.
 * A Corridor sprite.
 * Defines the characteristics of the the corridor, 
 */
public class Corridor extends Sprite{
	/** 
	 * Corridors's symbol
	 */ 
	public Symbol symbol=Symbol.CORRIDOR;
	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the corridor element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 */

	public Corridor(int row, int column) throws SpriteException {
		super(row, column, Symbol.CORRIDOR);
		
	}

}
