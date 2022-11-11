/*
 * Author: Neumann Davila
 * Date:   Nov 10, 2022
 * Description:
 *
 *
 * 
 */

package arrays;

import java.util.Scanner;

public class TwoDimArrays {
	
	public static void main(String[] args) {
		/*
		 * A 2D array is an array of arrays of a particular Data type
		 * 
		 * 
		 * dataType[][] arrayName = new dataType[#rows][#coloumns]
		 * 
		 * 
		 * 
		 */
		
		int[][] table = new int[5][3];
		
			// ArrayName.length -> returns the number of rows in the array
		System.out.println("Number of Rows: " + table.length);
		
			// ArrayName[#].length -> returns the number of coloumns in the row specified
		System.out.println("Number of Coloumns in Row 0: " + table[0].length);
		
		
		
		
	}
}

