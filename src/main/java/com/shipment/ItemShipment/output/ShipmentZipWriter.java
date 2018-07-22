package com.shipment.ItemShipment.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Zip range output Writer class.
 *
 */public class ShipmentZipWriter {
	
	/**
	 * Writes minimum ranged zip code to output stream.
	 * 
	 * @param outRange : The minimum number of ranges of zip code written to console.
	 */
	public void zipRangeWriter(List<String> outRange){
		
		// To switch to different output stream : Write to output file.
		/*
		 File file = new File("src/main/resources/ZipRange.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(outZipRange.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		 */

		ArrayList<String> outZipRange = new ArrayList<String>(outRange);

		// Getting String input
		System.out.print("Zip code range for Shipment : " + outZipRange.toString()); 	    	 
		
	}

}
