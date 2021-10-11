package edu.uoc.uocleaner.model;

public interface Movable {
	/**
	 * @author Fernando Sevilla Martínez
	 * @version 1.0
	 *
	 * Movable. 
	 * This interface declares one method that must encode all those elements
	 * capable to move. 
	 * This interface only contains the method declaration: moveTo.
	 */
	
	public static final int SPEED = 1;
	
	/**
	 * Abstract Method of "moveTo".
	 * Moves the object to the new row and column position.
	 * It will codify in each subclass
	 * @param row - the new row index
	 * @param column - the new column index
	 * @throws SpriteException 
	 */
	public abstract void moveTo(int row, int column) throws Exception;

}
