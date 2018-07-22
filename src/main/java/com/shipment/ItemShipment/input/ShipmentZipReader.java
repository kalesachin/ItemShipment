package com.shipment.ItemShipment.input;

import java.util.Scanner;

/**
 * Zip range input Reader class.
 *
 */
public class ShipmentZipReader {
	
	
	
	/**
	 * @return : A string as a range of zip Codes, read from input stream returned.
	 */
	public String zipCodeReader(){
			
			// To switch the input stream : read input from File.
			
			/*File text = new File("src/main/resources/inputZipCode.txt");
			Scanner input;
			try {
				input = new Scanner(text);		     
	        //Reading each line of file using Scanner class
	        int lineNumber = 1;
	        while(input.hasNextLine()){
	            String line = input.nextLine();
	            System.out.println("line " + lineNumber + " :" + line);
	            lineNumber++;
	        }
			} catch (FileNotFoundException e) {
			}*/
			
		Scanner input = null;
		String inputString = "";
		try {
			input = new Scanner(System.in);

			// Getting String input
			System.out.print(
					"Enter zip range in the format of [range1,range2] [range3,range4] & press enter once done: ");
			inputString = input.nextLine();
			System.out.println("Zip Code range entered is: " + inputString);
		} finally {
			if (input != null)
				input.close();
		}

		return inputString;
	}


}
