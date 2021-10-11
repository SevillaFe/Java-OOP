package edu.uoc.uocleaner.model;

/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Subclass from Sprite.
 * A Wall sprite.
 * Defines the characteristics of the the Wall, 
 */
public class Wall extends Sprite{
	/**
	 * Corridors's symbol
	 */
	public Symbol symbol=Symbol.WALL;
	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the corridor element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 */
	public Wall(int row, int column) throws SpriteException {
		super(row, column, Symbol.WALL);
		
	}

}