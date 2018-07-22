package com.shipment.ItemShipment.exception;

/**
 * An Exception wrapper class to handle the runtime business errors for
 * ShipmentLocator class.
 *
 */
public class ShipmentLocatorException extends Exception {

	/**
	 * Default Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception wrapper method for system errors.
	 * 
	 * @param message : An exception message indicating error occurred.
	 */
	public ShipmentLocatorException(String message) {
		super(message);
		System.out.println("ShipmentLocatorException: " + message);
	}

	/**
	 *  System exception wrapped around business exception.
	 *  
	 * @param exception : Runtime exception occurred.
	 */
	public ShipmentLocatorException(Exception exception) {
		super(exception);
		System.out.println("ShipmentLocatorException: " + exception);
	}
}
