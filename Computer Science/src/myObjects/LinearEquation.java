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

public class LinearEquation {
 /*
  * A class is a blueprint for an object
  * The class tells us the attributes (variables)
  * and the behaviours (methods) associated with the object
  */
	
		//	All linear Equations have a slope and all non-vertical lines have a y-intercept
	
		//	Class level variables exist for the entire class in any method
		// cass variables are private so that they can only be accessed within the class
	
	private double slope, yInt;
	
		// A constructor is a special method that generally initializes the class variabels of the object
		// always the name of the class
	
	public LinearEquation (double slope, double yInt) {
		
			//	this. connects the class variables to the input parameters 
		this.slope = slope;
		this.yInt = yInt;
		
	}
	
		//	Methods that allow you to acces the variables from outside the class without making the variable public
	public double getSlope() {
		return this.slope;
	}
	
	public double getY () {
		return this.yInt;
	}
	
		//	Methods that set allow for variables to be set from outside the class
	public void setSlope(double newSlope) {
		this.slope = newSlope;
	}
	
	public void setY(double newY) {
		this.yInt = newY;
	}
	
	public void showEquation() {
		System.out.printf("y = %.1fx + %.1f", slope, yInt);
		System.out.println("");
	}
}

