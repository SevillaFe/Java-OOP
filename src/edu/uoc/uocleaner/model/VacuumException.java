package edu.uoc.uocleaner.model;
/**
 * @author Fernando Sevilla Martínez
 * @version 2.0
 *
 * Class containing the customs exceptions
 */
public class VacuumException extends Exception{

	/**
	 * Attribute created for serialization
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error message when the initial maximum capacity of the vacuum cleaner is zero or negative.
	 */
	public static final String ERROR_MAX_CAPACITY_VALUE="[ERROR] The maximum capacity of the vacuum cleaner cannot be 0 or a negative value!!";
	
	/**
	 * Error message when the increment of the vacuum cleaner's capacity is a negative value.
	 */
	public static final String ERROR_INC_CAPACITY_NEGATIVE_VALUE="[ERROR] The increment of the capacity cannot be a negative value!!";
	/**
	 * Error message when the player is trying to overflow the maximum capacity of the vacuum cleaner.
	 */
	public static final String ERROR_OVERFLOW_MAX_CAPACITY="[ERROR] You are trying to overflow the maximum capacity of the vacuum";
	
	/**
	 * Error message when the current capacity of the vacuum cleaner is a negative value.
	 */
	public static final String ERROR_CAPACITY_NEGATIVE_VALUE="[ERROR] The capacity cannot be a negative value!!";
	
	/**
	 * VacuumException's message
	 */
	private String msg;
	/**
	 * Default constructor:
	 */
	public VacuumException() {
		
	}
	/**
	 * Parameterized constructor.
	 * @param msg New msg that we want to show when the exception is throw
	 */
	public VacuumException(String msg) {
        super(msg);
        this.msg = msg;
    }
	/**
	 * {@inheritDoc}
	 * Getter for "msg".
	 */
    @Override
    public String getMessage() {
        return this.msg;
    }

}
