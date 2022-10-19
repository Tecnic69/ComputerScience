/*
 * Author: Neumann Davila
 * Date:   Oct 18, 2022
 * Description:
 *
 *
 * 
 */

package arrays;

import java.util.Scanner;

public class ArrayLesson {

	public static void main(String[] args) {
		/*
		 * An Array is a data structure that holds "values" of the same data type
		 * 
		 * An array is fixed to a set number of values when it is initialized
		 * 
		 * Elements of an array are accessed at by using arrayName[index]
		 * starting at 0 (arrayName.length - 1)
		 * 
		 * For an array of primative data types default value is "0"
		 * 
		 * For an array of objects the default value is "null"
		 */
		
		
			//	dataType[] arrayName = new dataType[arraySize]
			//	dataType[] arrayNam = {array elements, seperated by commas}
		
		int[] numbers = new int[50];
		
//		numbers[0] = 7;
		
			//	You can iterate through an array by:
		
			//	traditional for loop -> can acces and change values in array
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");	
		
			//	Enhanced for loop -> can only acces (read-only) the values of the array; cannot change values
			//	for(dataType single : collection) --> loop body
		
		for(int number : numbers) {
			number = number * number + number;
			System.out.print(number + " ");
		}
		
	}

}

