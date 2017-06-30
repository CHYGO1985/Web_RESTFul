package org.jingjie.restful.messenger.exception;

/**
 * The exception is for trying to get a non-existing message.
 * (i.e. message id that does not exist.) 
 * 
 * @author jingjiejiang
 * @history
 * 1. Jun 29, 2017
 */
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
