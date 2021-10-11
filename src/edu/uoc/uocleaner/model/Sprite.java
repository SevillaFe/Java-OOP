package edu.uoc.uocleaner.model;

/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Superclass for elments subclasses. 
 * Defines the common characteristics of the elements if the game 
 */
public abstract class Sprite {
	
	/**
	 * Index of the row in which the sprite is.
	 */
	private Symbol symbol;
	/**
	 * Index of the column in which the sprite is.
	 */
	private int column;
	/**
	 * Symbol that represents the ASCII character/symbol of the sprite.
	 */
	private int row;
	
	/**
	 * Parameterized protected constructor
	 * @param column Index of the column in which the sprite is.
	 * @param Index of the row in which the sprite is.
	 * @param Symbol that represents the ASCII character/symbol of the sprite.
	 * @throws SpriteException - When the index of either the row or the column is negative.
	 */
	protected Sprite( int row, int column, Symbol symbol) throws SpriteException {
		//super();
		setSymbol(symbol);
		this.column=column;
		this.row=row;
	}

	/**
	 * Getter of column.
	 * @return The value of the column index.
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * Setter of column.
	 * @param column - Index to assign to the sprite's column.
	 * @throws SpriteException - When the index to assign is negative.
	 */
	public void setColumn(int column) throws SpriteException{
		if(column<0) {
			throw new SpriteException(SpriteException.ERROR_INDEX_COLUMN_INCORRECT);
		}else {
			this.column = column;	
		}
	}
	/**
	 * Getter of row.
	 * @return The value of the row index.
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Setter of row.
	 * @param row - Index to assign to the sprite's row.
	 * @throws SpriteException - When the index to assign is negative.
	 */
	public void setRow(int row) throws SpriteException{
		if(row<0) {
			throw new SpriteException(SpriteException.ERROR_INDEX_ROW_INCORRECT);
		}else {
			this.row = row;
		}	
	}
	/**
	 * Getter of symbol.
	 * @return Symbol that represents the ASCII character/symbol and the image of the sprite.
	 */
	public Symbol getSymbol() {
		return symbol;
	}
	
	/**
	 * Setter of symbol.
	 * @param symbol - Symbol that represents the ASCII character/symbol and the image to assign to the sprite.
	 */
	private void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	} 
	/** 
	 * {@inheritDoc}
	 * It returns the ASCII character/symbol of the sprite.
	 * @return String ASCII character/symbol of the sprite.
	 */
	@Override
	public String toString() {
		return symbol.toString() ;
	}
	/**
	 * Two objects are identical when they have the same symbol, row index and column index.
	 * {@inheritDoc}
	 * @param other - Object to compare. return True if the two objects are identical. Otherwise, it returns false.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object)
	        return true;
		
		Sprite a = (Sprite)object;
	    return (a.getSymbol().equals(this.symbol) && 
	    		a.getColumn()==(this.column) &&
	    		a.getRow()==(this.row)) ;
	}
	
	
}
