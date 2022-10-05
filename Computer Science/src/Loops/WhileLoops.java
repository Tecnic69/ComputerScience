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

public class WhileLoops {

	public static void main(String[] args) {
		validate();
	}
	//	while loops are used when a lopp is absolutely necissary but the amount it is going to loop is unknown
	//	runs as long as the boolean statment is true
	

	public static void validate() {
		Scanner input = new Scanner(System.in);
		String userIn = "";
		
		while (!userIn.equals("N")) {
			System.out.println("Do you want to continue. Type 'N' to quit. Anything else to continue");
			userIn = input.nextLine();
		}
		System.out.println("terminated");
	}
	
}

