package com.shipment.ItemShipment.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.shipment.ItemShipment.exception.ShipmentLocatorException;

/**
 * Zip Code range processor class.
 * 
 * It produces the minimum number of ranges required to represent the same
 * restrictions as the input range of zipCode.
 *
 */
public class ZipRangeProcessor {

	private TreeSet<Integer> lowerBound = new TreeSet<Integer>();
	private TreeSet<Integer> upperBound = new TreeSet<Integer>();

	/**
	 * It processes the range of zipe codes read from input stream & generates
	 * the new set of minimum ranged zip Codes by retaining the same
	 * restrictions as the input
	 * 
	 * @param inputString
	 *            : The range of zip codes read from input stream.
	 * @return : minimum ranged zip Codes
	 * @throws ShipmentLocatorException
	 *             : {@link ShipmentLocatorException}
	 */
	public List<String> processRange(String inputString) throws ShipmentLocatorException {

		String[] arrayOfInputString = inputString.split(",|\\[|\\]");

		try {

			for (int x = 0, a = 1; x < arrayOfInputString.length; x++) {

				if (x == a) {
					lowerBound.add(new Integer(arrayOfInputString[x]));
					a = a + 3;

					upperBound.add(new Integer(arrayOfInputString[x + 1]));
				}

			}
			if (lowerBound.size() != upperBound.size()) {
				throw new ShipmentLocatorException("ZipCode Range mismatch.");
			}

			Integer[] arrayLowerBound = new Integer[lowerBound.size()];
			Integer[] arrayUpperBound = new Integer[upperBound.size()];
			arrayLowerBound = lowerBound.toArray(arrayLowerBound);
			arrayUpperBound = upperBound.toArray(arrayUpperBound);

			List<String> outputRange = new ArrayList<String>();
			String strTemp;

			for (int a = 0, tempUpperRange = 0, tempLowerRange = 0; a < arrayUpperBound.length; a++) {

				tempLowerRange = arrayLowerBound[a];
				for (int b = a; b < arrayUpperBound.length; b++) {
					tempUpperRange = arrayUpperBound[a];
					if (a + 1 < arrayLowerBound.length && b + 1 < arrayUpperBound.length) {
						if (tempUpperRange > arrayLowerBound[a + 1] && tempUpperRange < arrayUpperBound[b + 1]) {
							tempUpperRange = arrayUpperBound[b + 1];
							++a;

						}
					}
				}
				strTemp = "[" + tempLowerRange + "," + tempUpperRange + "]";
				tempLowerRange = 0;
				tempUpperRange = 0;
				outputRange.add(strTemp);
			}
			return outputRange;
		} catch (NumberFormatException numberFormatException) {
			throw new ShipmentLocatorException(numberFormatException);
		}
	}

}
