/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 *
 *
 * 
 */

package myObjects;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		LinearEquation line = new LinearEquation(2, 3);
		
		LinearEquation line2 =  new LinearEquation(6, 3);
			// the dot operator (scnr. ) allows you to call variables and methods from this class
			
		System.out.println(line2.getSlope());

	}

}

