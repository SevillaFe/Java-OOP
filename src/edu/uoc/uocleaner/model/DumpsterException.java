package edu.uoc.uocleaner.model;
/**
 * @author Fernando Sevilla Martínez
 * @version 2.0
 *
 * Class containing the customs exceptions
 */
public class DumpsterException extends Exception{

	/**
	 * Attribute created for serialization
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error message when the load of the dumpster is negative.
	 */
	public static final String ERROR_LOAD_NEGATIVE_VALUE="[ERROR] Load cannot be negative!!";
	
	/**
	 * DumpsterException's message
	 */
	private String msg;
	/**
	 * Default constructor:
	 */
	public DumpsterException() {
		
	}
	/**
	 * Parameterized constructor.
	 * @param msg New msg that we want to show when the exception is throw
	 */
	public DumpsterException(String msg) {
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
