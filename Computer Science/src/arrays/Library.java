/*
 * Author: Neumann Davila
 * Date:   Oct 20, 2022
 * Description:
 *
 *
 * 
 */

package arrays;

import java.util.Scanner;

public class Library {
	
	private static int count = 0; 
	private Book[] library;

		//	a deafault library contains 1 book
	public Library() {
		library = new Book[1];
		
		library[0] = new Book();
		
		count++;
	}
	
	public Library(int num) {
		library = new Book[num];
	}
}

