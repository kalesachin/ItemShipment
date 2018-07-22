package com.shipment.ItemShipment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shipment.ItemShipment.exception.ShipmentLocatorException;
import com.shipment.ItemShipment.processor.ZipRangeProcessor;

/**
 * Unit test for ZipRangeProcessor.
 * 
 * {@link ZipRangeProcessor}
 */
public class ZipRangeProcessorTest {

	ZipRangeProcessor zipRangeProcessor = new ZipRangeProcessor();

	/**
	 * Use case - 1.
	 * Positive test case.
	 * Comparing against correct OutPut - assertion should succeed.
	 * 
	 * input : "[94133,94133] [94200,94299] [94600,94699]";
	 * outputToCompare : "[94133,94133] [94200,94299] [94600,94699]"
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test
	public void AssertOutPutRangeForTrueCaseOne() throws ShipmentLocatorException {
		List<String> outputToCompare = new ArrayList<String>();
		outputToCompare.add("[94133,94133]");
		outputToCompare.add("[94200,94299]");
		outputToCompare.add("[94600,94699]");
		String inputString = "[94133,94133] [94200,94299] [94600,94699]";
		List<String> outputZipRange = zipRangeProcessor.processRange(inputString);
		assertTrue(outputZipRange.equals(outputToCompare));
	}

	/**
	 * Use case - 2.
	 * Positive test case.
	 * Comparing against correct OutPut - assertion should succeed.
	 * 
	 * input : "[94133,94133] [94200,94299] [94226,94399]";
	 * outputToCompare : "[94133,94133] [94200,94399]"
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test
	public void AssertOutPutRangeForTrueCaseTwo() throws ShipmentLocatorException {
		List<String> outputToCompare = new ArrayList<String>();
		outputToCompare.add("[94133,94133]");
		outputToCompare.add("[94200,94399]");
		String inputString = "[94133,94133] [94200,94299] [94226,94399]";
		List<String> outputZipRange = zipRangeProcessor.processRange(inputString);
		assertTrue(outputZipRange.equals(outputToCompare));
	}
	
	/**
	 * Positive test case.
	 * Comparing against correct OutPut - assertion should succeed.
	 * 
	 * input : "[100,300][150,400] [500,700] [10,40]";
	 * outputToCompare : "[10,40] [100,400][500,700]"
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test
	public void AssertOutPutRangeForTrueCaseThree() throws ShipmentLocatorException {
		List<String> outputToCompare = new ArrayList<String>();
		outputToCompare.add("[10,40]");
		outputToCompare.add("[100,400]");
		outputToCompare.add("[500,700]");
		String inputString = "[100,300][150,400] [500,700] [10,40]";
		List<String> outputZipRange = zipRangeProcessor.processRange(inputString);
		assertTrue(outputZipRange.equals(outputToCompare));
	}

	/**
	 * Negative test case.
	 * Comparing against wrong OutPut - assertion should fail.
	 * 
	 * input : "[100,300][150,400] [500,700] [10,40]";
	 * wrongOutputToCompare : "[10,4000] [100,40][500,7900]"
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test
	public void AssertOutPutRangeForFalseCaseThree() throws ShipmentLocatorException {
		List<String> wrongOutputToCompare = new ArrayList<String>();
		wrongOutputToCompare.add("[10,4000]");
		wrongOutputToCompare.add("[100,40]");
		wrongOutputToCompare.add("[500,7900]");
		String inputString = "[100,300][150,400] [500,700] [10,40]";
		List<String> outputZipRange = zipRangeProcessor.processRange(inputString);
		assertFalse(null, outputZipRange.equals(wrongOutputToCompare));
	}

	/**
	 * Negative test case.
	 * Tests the improper input - the LowerBound missing condition;
	 * "[100,300][150,400] [,790] [10,40]"; Expects exception to be thrown.
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test(expected = ShipmentLocatorException.class)
	public void AssertOutPutRangeForLowerBoundExceptionCaseThree() throws ShipmentLocatorException {
		List<String>  outputToCompare = new ArrayList<String>();
		outputToCompare.add("[10,40]");
		outputToCompare.add("[100,400]");
		outputToCompare.add("[500,790");
		String inputString = "[100,300][150,400] [,790] [10,40]";
		zipRangeProcessor.processRange(inputString);
	}

	/**
	 * Negative test case.
	 * Tests the improper input - the UpperBound missing condition;
	 * "[100,300][150,400] [500] [10,40]"; Expects exception to be thrown.
	 * 
	 * @throws ShipmentLocatorException
	 */
	@Test(expected = ShipmentLocatorException.class)
	public void AssertOutPutRangeForUpperBoundExceptionCaseThree() throws ShipmentLocatorException {
		List<String>  outputToCompare = new ArrayList<String>();
		outputToCompare.add("[10,40]");
		outputToCompare.add("[100,400]");
		outputToCompare.add("[500,790");
		String inputString = "[100,300][150,400] [500] [10,40]";
		zipRangeProcessor.processRange(inputString);
	}

}
