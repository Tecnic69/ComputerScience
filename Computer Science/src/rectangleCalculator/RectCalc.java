/*
 * Author: Neumann Davila
 * Date:   Sep 15, 2022
 * Description:
 * Learn to write static methods for a rectangle
 * Calculatting area, perimeter, and length of diagonal
 * Method that states the information
 */

package rectangleCalculator;

import java.util.Scanner;

public class RectCalc {

	/*
	 *When writing a method, it must have:
	 *
	 * 1.) scope level --> public,private
	 * 2.) static / non-static 
	 * 3.) return type --> int, String, boolean, void
	 * 4.) name
	 * 5.) method parameters must be stated in the method header
	 * 6.) calls must include the parameters required for the method in the correct order
	 * 
	 * 
	 */
	
		//This method returns the area of a rectangle with int sides
	public static int getArea(int length , int width) {
		return length * width;
	}
	
		//This method finds the perimeter of a rectangle 
	public static int getPerim(int length, int width) {
		return 2 * (length + width);
	}
	
		//This method finds the diagonla of a rectangle
	public static double getDiag(int length , int width) {
		return Math.sqrt((length * length) + (width * width));
	}
	
		//this method creates a summary of the rectangle information
	public static void getSummary() {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int width = input.nextInt();
		System.out.printf("The dimensions of the rectangle are %d x %d.\n" , length , width);
		System.out.printf("The area of the rectangle is %d.\n" , getArea(length , width));
		System.out.printf("The perimeter of the rectangle is %d.\n" , getPerim(length , width));
		System.out.printf("The diagonal length of the rectangle is %.1f.\n " , getDiag(length , width));
	}
	
	
	public static void main(String[] args) {
		getSummary();
	}

}

