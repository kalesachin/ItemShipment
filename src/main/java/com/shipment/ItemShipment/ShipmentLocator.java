package com.shipment.ItemShipment;

import java.util.ArrayList;
import java.util.List;

import com.shipment.ItemShipment.exception.ShipmentLocatorException;
import com.shipment.ItemShipment.input.ShipmentZipReader;
import com.shipment.ItemShipment.output.ShipmentZipWriter;
import com.shipment.ItemShipment.processor.ZipRangeProcessor;

/**
 * Shipment Locator!
 * 
 * A class to locate the shipment based on input Zip code.
 * 
 * It'll narrow down the zip code range by figuring out overlapping zip codes,
 * still retaining the same restrictions imposed by input zip code range.
 * 
 * TODO : Dependencies are fed using new; IOC to be used like Spring.
 *
 */
public class ShipmentLocator {

	public static void main(String[] args) {
		System.out.println("Welcome to Shipment - Zip Code range locator!");

		ShipmentLocator shipmentLocations = new ShipmentLocator();
		shipmentLocations.shipmentLocatorOnZipCode();
	}

	private void shipmentLocatorOnZipCode() {
		ShipmentZipReader shipmentZipReader = new ShipmentZipReader();
		ShipmentZipWriter shipmentZipWriter = new ShipmentZipWriter();
		String inputString = shipmentZipReader.zipCodeReader();

		ZipRangeProcessor zipRangeProcessor = new ZipRangeProcessor();

		List<String> outputRange = new ArrayList<String>();

		try {
			outputRange = zipRangeProcessor.processRange(inputString);
		} catch (ShipmentLocatorException e) {
			System.out.println("Encontered exception: " + e);
		}
		shipmentZipWriter.zipRangeWriter(outputRange);
	}
}
