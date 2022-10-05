/*
 * Author: Neumann Davila
 * Date:   Sep 6, 2022
 * Description: String Methods lesson
 *
 *
 * 
 */

package introLessonOne;

import java.util.Scanner;

public class StrngLesson {

	public static void main(String[] args) {
		
		String myName = "Neumann";
		
		
		
			//	1.) The .indexOf(target) returns the first instance of the occurance od 'target'
			//		-1 is returned if the target is not located in the string 
			//		data structures are 0 indexed (starting at 0)
		
		System.out.println("The index of N is: " + myName.indexOf("N"));
		
			//		.indexOf(target , startingPoint) --> starts at startingPoint
		
		System.out.println("The index of n is: " + myName.indexOf("n" , myName.indexOf("n") + 1));
		
			//	2.) .charAt(index) --> return character at location 'index'
		
		System.out.println("The character at index = 3 is: " + myName.charAt(3));
		
			//		outOfBound Exception if the index is greatedr than the amount of characters in the string
		
			//	3.) .length() --> returns the length of the string
			//		final index is always .length() - 1;
		
		System.out.println("There are " + myName.length() + " letters in my name!");
		
			//	4.)	.toLowerCase() and .toUpperCase() --> returns a string that is all lowercase ( or uppercase)
			//		neither method changes the value of the existing string
		
		System.out.println("Lowercase: " + myName.toLowerCase());
		System.out.println(myName);
		System.out.println("Uppercase: " + myName.toUpperCase());
		System.out.println(myName);
		
			//	5.)	.substring(startIndex , endIndex) --> returns that string that begins at 'startIndex' until the
			//		end of the string or endIndex (if added)

		System.out.println("A substring from the 3rd index is: " + myName.substring(3 , 4));
			
			//	6.)	.repeat(numRepeat) --> repeats numRepeat times
		
		String rep = myName.repeat(6);
		System.out.println(rep);
		
			//	7.) formatting --> System.out.printf("%#s", String); System.out.printf("%d", 8);
		String test = "text";
		
			//		%-20sthis, test; creates 20 spaces between test and this
			//		%20sthis, test; creates the this test 20 spaces away with test starting
		System.out.printf("%20sthis", test);
		
	}

}

