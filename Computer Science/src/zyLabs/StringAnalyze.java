/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 *
 *
 * 
 */

package zyLabs;

import java.util.Scanner;

public class StringAnalyze {
	public static String commonLetters(String userIn1, String userIn2) {
		String commonLetters = "";
			//	Sets the strings to all lower case
		userIn1 = userIn1.toLowerCase();
		userIn2 = userIn2.toLowerCase();
		
			//	for loop goes through each char in the first userIn
			//	the Second for loop compares each char of the secnd userIn to the char currently being used in the first for loop 
		for (int i = 0; i < userIn1.length(); i++) {
			for  (int j = 0; j < userIn2.length(); j++) {
					//	compares the characters between the first and second string
					//	also checks if the letter has already been identified
				if (userIn1.charAt(i) == userIn2.charAt(j) && commonLetters.indexOf(userIn1.charAt(i)) == -1) {
					commonLetters += userIn1.charAt(i);
				}
			}
		}
			//	returns <none> if there are no values are simillar
		if (!commonLetters.equals("")) {
			return commonLetters;
		}
		else {
			return "<none>";
		}
	}
	
	public static String swapHere(String userIn, int splitValue) {
		String splitString;
		splitValue -= 1;
		
		if (splitValue < 0 || splitValue > userIn.length() - 1) {
			return userIn;
		}
		splitString = userIn.substring(splitValue);
		splitString += userIn.substring(0 , splitValue);
		
		return splitString;
	}
	
	public static int letterSum(String userIn) {
		int sum = 0;
			//	sets userIn to lower case
		userIn = userIn.toLowerCase();
		
			//	the foor loop will iterate through each char of userIn
		for (int i = 0; i < userIn.length(); i++) {
				//	checks if the character is an alpha character
			if (userIn.charAt(i) >= 'a' && userIn.charAt(i) <= 'z') {
					//	if alpha char then add to the sum
				sum += userIn.charAt(i) - 96;
			}
		}
		return sum;
	}
	
	public static boolean isValidPassword(String userIn) { 
		int nums = 0;
		int capLetters = 0;
		int lowLetters = 0;
		
			// checks if the length 8 or greater for a password
			//	meeting the first condition of the password
			//	if this is not met then the method returns false
		if (userIn.length() >= 8) {
				//	for loop iterates through each char of the userIn
			for (int i = 0; i < userIn.length(); i++) {
					//	creates a temp char to check to see if the char is one of the following casses:
					//	numbers; capital letters; lower case letters
					//	if it is not one of these then the method returns false
				char tempChar = userIn.charAt(i);
				if (tempChar >= '0' && tempChar <= '9') {
					nums++;
				}
				else if (tempChar >= 'A' && tempChar <= 'Z') {
					capLetters++;
				}
				else if (tempChar >= 'a' && tempChar <= 'z') {
					lowLetters++;
				}
				else {
					return false;
				}
			}
		}
			//	checks if the UserIn contains the proper number of th 3 cases previoulsy checked
			//	if all cases are met then the method returns true, if not it returns false
		if (nums >= 2 && capLetters >= 2 && lowLetters >= 2) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
	}
}

