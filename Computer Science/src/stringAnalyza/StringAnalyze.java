/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 *
 *
 * 
 */

package stringAnalyza;

import java.util.Scanner;

public class StringAnalyze {
	public static String commonLetters(String userIn1, String userIn2) {
		String commonLetters = "";
		userIn1 = userIn1.toLowerCase();
		userIn2 = userIn2.toLowerCase();
		
		for (int i = 0; i < userIn1.length(); i++) {
			for  (int j = 0; j < userIn2.length(); j++) {
				if (userIn1.charAt(i) == userIn2.charAt(j)) {
					commonLetters += userIn1.charAt(i);
				}
			}
		}
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
		
		if (splitValue == 0 || splitValue > userIn.length() - 1) {
			return userIn;
		}
		splitString = userIn.substring(splitValue);
		splitString += userIn.substring(0 , splitValue);
		
		return splitString;
	}
	
	public static int letterSum(String userIn) {
		int sum = 0;
		userIn = userIn.toLowerCase();
		
		for (int i = 0; i < userIn.length(); i++) {
			if (userIn.charAt(i) >= 'a' && userIn.charAt(i) <= 'z') {
				sum += userIn.charAt(i) - 96;
			}
		}
		return sum;
	}
	
	public static boolean isValidPassword(String userIn) { 
		int nums = 0;
		int capLetters = 0;
		int lowLetters = 0;
		
		if (userIn.length() >= 8) {
			for (int i = 0; i < userIn.length(); i++) {
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

