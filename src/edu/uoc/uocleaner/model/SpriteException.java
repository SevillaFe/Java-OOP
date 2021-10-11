package edu.uoc.uocleaner.model;
/**
 * @author Fernando Sevilla Martínez
 * @version 2.0
 *
 * Class containing the customs exceptions
 */
public class SpriteException extends Exception {

	/**
	 * Attribute created for serialization
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error message when the index of the column is negative.
	 */
	public static final String ERROR_INDEX_ROW_INCORRECT="[ERROR] The index of row cannot be negative!!";
	
	/**
	 * Error message when the index of the row is negative.
	 */
	public static final String ERROR_INDEX_COLUMN_INCORRECT="[ERROR] The index of column cannot be negative!!";
	
	/**
	 * SpriteException's message
	 */
	private String msg;
	/**
	 * Default constructor:
	 */
	public SpriteException() {
		
	}
	/**
	 * Parameterized constructor.
	 * @param msg New msg that we want to show when the exception is throw
	 */
	public SpriteException(String msg) {
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
