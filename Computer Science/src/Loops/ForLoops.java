/*
 * Author: Neumann Davila
 * Date:   Sep 27, 2022
 * Description:
 *
 *
 * 
 */

package Loops;

import java.util.Scanner;

public class ForLoops {

	public static void main(String[] args) {
//		printIncreasingNumbers(0, 10);
//		printDecreasingNumbers(50, 30);
		System.out.println(reverseString("dog"));
	}
	
	
	/*	for loops executes thr same code at a set nu ber of times
	 *	for loop format:
	 *
	 *	for (loopVariable = Start Value; Condition to continue iterating ; incrementing loop variable) {
	 *		//loop body --> executed code
	 *	}
	 */
	
		// this method prints increasing numbers from start to stop
	public static void printIncreasingNumbers(int start, int stop) {
		for (int i = start; i <= stop; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("done.");
	}
		// prints decreaing numbers from start to stop
	public static void printDecreasingNumbers(int start, int stop) {
		for (int i = start; i >= stop; i--) {
			System.out.print(i + ", ");
		}
		System.out.println("done.");
	}
	public static String reverseString(String userIn) {
		String reverse = "";
		for (int i = (userIn.length() - 1); i >= 0; i-- ) {
			reverse += userIn.charAt(i);
		}
		return reverse;
	}
	
}

