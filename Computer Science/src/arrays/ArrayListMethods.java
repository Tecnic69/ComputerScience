/*
 * Author: Neumann Davila
 * Date:   Nov 15, 2022
 * Description:
 *
 *
 * 
 */

package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMethods {
	
	public static void main(String[] args) {
		/*
		 * An Arryalist canot hold primative data types
		 * 
		 * primative dataTypes most be converted to there original objects
		 * 
		 * int -> Integer; char -> character; etc.
		 * 
		 * 2D arrayLists are possible 
		 */
		
		ArrayList<ArrayList<Integer>> numbers2 = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		
		/*
		 * 				Method List:
		 * 
		 * .add(element) -> adds to an arrayList
		 * 
		 * .add(insertionIdex, value) -> inserts values at the index and shifts all value index by one
		 * 
		 * .get(index) -> pulls a method from the list
		 * 
		 * .size() -> return the number of elements in the list
		 * 
		 * .remove(index) -> deletes value and reduces indexes of values above by one
		 * 
		 */
		
			//	Prints array in [value, value] <----!!!!!
		System.out.println(numbers);
		
	}
}

