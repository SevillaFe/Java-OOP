package edu.uoc.uocleaner.model;

/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Subclass from Sprite.
 * A Dumpster sprite.
 * Defines the characteristics of the the Dumpster, 
 */
public class Dumpster extends Sprite{
	/**
	 * Corridors's symbol
	 */
	public Symbol symbol=Symbol.DUMPSTER;
	/**
	 * Points which are added to the vacuum cleaner's capacity.
	 */ 
	private int load = 0;
	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the dumpster element is.
	 * @param column - Index of the column in which the corridor element is.
	 * @throws SpriteException - When the index of the row or the column is incorrect.
	 * @throws DumpsterException - When the load is negative.
	 */
	public Dumpster(int row, int column) throws SpriteException {
		super(row, column, Symbol.DUMPSTER);
	}

	/**
	 * Getter of load.
	 * @return The points which have been loaded to the dumpster.
	 */
	public int getLoad() {
		return load;
	}
	/**
	 * Setter of load.
	 * @param load - Points that have to be loaded to the dumpster.
	 * @throws DumpsterException - When the load is negative.
	 */
	public void setLoad(int load) throws DumpsterException{
		if(load<0) {
			throw new DumpsterException(DumpsterException.ERROR_LOAD_NEGATIVE_VALUE);
		}else {
			this.load = load;
		}
	}
	
	/**
	 * Add the specified load to the dumpster's current load.
	 * @param load - Quantity of load to add to the dumpster's current load.
	 * @throws DumpsterException - When the load is negative.
	 */
	public void addLoad(int load) throws DumpsterException{ //the load value received as a parameter can be negative.
		if(this.load+load<0) { 
			throw new DumpsterException(DumpsterException.ERROR_LOAD_NEGATIVE_VALUE);
		}else 
			this.load=this.load+load; //Add the specified load to the dumpster's current load.
		}
	
}
