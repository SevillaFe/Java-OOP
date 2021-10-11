package edu.uoc.uocleaner.model;
/**
 * @author Fernando Sevilla Martínez
 * @version 1.0
 *
 * Subclass from Sprite.
 * A Dumpster sprite.
 * Defines the characteristics of the the Dumpster, 
 */
public class Vacuum extends Sprite implements Movable{
	
	public Symbol symbol=Symbol.VACUUM;
	/**
	 * Current quantity of dirt that the vacuum cleaner is storing.
	 */
	private int capacity = 0;
	/**
	 * Maximum capacity of dirt that the vacuum cleaner can store.
	 */
	private int MAX_CAPACITY;
	/**
	 * The sprite that was in the cell before the vacuum cleaner.
	 */
	private Sprite under;
	/**
	 * Parameterized constructor
	 * @param row - Index of the row in which the vacuum cleaner is initially.
	 * @param column - Index of the column in which the vacuum cleaner is initially.
	 * @param maxCapacity - Maximum capacity of dirt that the vacuum cleaner can store.
	 * @throws VacuumException - When the value for the vacuum cleaner's maximum capacity is zero or negative; 
	 * when the value for the vacuum cleaner's current capacity is negative or higher than the maximum capacity.
	 * @throws SpriteException - When the index of either the row or the column is incorrect.
	 */
	public Vacuum(int column, int row, int MAX_CAPACITY) throws VacuumException, SpriteException {
		super(row, column, Symbol.VACUUM);
		if(MAX_CAPACITY<0) {
			throw new VacuumException(VacuumException.ERROR_MAX_CAPACITY_VALUE);
		}else {
			this.MAX_CAPACITY = MAX_CAPACITY;
		};
		this.under= new Corridor(column, row); //Under attribute value assigned to an object of type Corridor
		
	}
	/**
	 * Getter of the field "capacity"
	 * @return The value of the field "capacity", 
	 * i.e. the current quantity of dirt that the vacuum cleaner is storing.
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Increases the value of "inc" the current capacity of the vacuum cleaner.
	 * @param inc - Amount to add to the current capacity of the vacuum cleaner.
	 * @throws VacuumException - When the value of the passed capacity is negative or 
	 * higher than the maximum capacity; When the increment value is a negative value.
	 */
	public void incCapacity(int inc) throws  VacuumException{
		try { // If exception ocurrs then do nothing 
			if(inc<0) {
				throw new VacuumException(VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
			}else {
				if((getCapacity()+inc)>this.MAX_CAPACITY) {
					throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
				}else{
					this.capacity=getCapacity()+inc;
					}
				}		
		}catch(Exception e) {
			this.capacity=getCapacity();
			}	
	}
	/**
	 * Setter of the field "capacity".
	 * @param capacity - Value to assign to the field "capacity".
	 * @throws VacuumException - When the value of the passed capacity is negative 
	 * or higher than the maximum capacity.
	 */
	public void setCapacity(int capacity) throws VacuumException {
		try {
			if(capacity<0 || capacity>this.MAX_CAPACITY) {
				throw new VacuumException(VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE);
			}else {
				this.capacity = capacity;
				}
			}
		catch (Exception e) {
			this.capacity=getCapacity();
			}	
	}
	/**
	 * Getter of MAX_CAPACITY.
	 * @return The value of MAX_CAPACITY.
	 */
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}

	/**
	 * Getter of the field "under".
	 * @return The value of the field "under", i.e. the sprite that was in the cell before the vacuum cleaner.
	 */
	public Sprite getUnder() {
		return under;
	}
	/**
	 * Setter of the field "under" which stores the sprite that was in the cell before the vacuum cleaner.
	 * @param under - Sprite that was in the cell before the vacuum cleaner.
	 */
	public void setUnder(Sprite under) {
		this.under = under;
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
		// TODO Auto-generated method stub
		this.setRow(row);
		this.setColumn(column);	
	}
	/**
	 * Empties the Vacuum.
	 * @throws VacuumException - When the value of the passed capacity is negative 
	 * or higher than the maximum capacity.
	 */
	public void empty() throws VacuumException{
		this.capacity=0;
	}
	
}
