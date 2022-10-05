/*
 * Author: Neumann Davila
 * Date:   Sep 27, 2022
 * Description:
 *
 *
 * 
 */

package practice;

import java.util.Scanner;

public class QuadraticCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a, b, c;
		double discriminant;
		double zero1, zero2;
		
		System.out.println("Pleas provide the numbers a b c");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		discriminant = Math.pow(b, 2.0) - 4 * a * c;
		
		if (discriminant > 0) {
			zero1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			zero2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			System.out.printf("The equation has two roots %.4f, %.4f", zero1, zero2);
		}
		else if (discriminant == 0) {
			zero1 = -b / (2*a);
			System.out.printf("The equation is %.4f", zero1);
		}
		else {
			System.out.println("The equation has no real roots");
		}
	}
}

