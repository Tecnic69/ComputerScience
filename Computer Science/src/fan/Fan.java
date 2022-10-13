/*
 * Author: Neumann Davila
 * Date:   Oct 13, 2022
 * Description:
 *
 *
 * 
 */

package fan;

import java.util.Scanner;

public class Fan {
	
	private String color;
	private boolean isOn;
	private int speed;
	private double radius;
	
	
		//	Constructors always have the name of the class
		//	any amount of constructors are allowed as long as the parameters are different
	
	
		//	Constructor for default fan
	public Fan () {
		this.speed = 1;
		this.isOn = false;
		this.radius = 5;
		this.color = "Blue";
	}
		//	custom fan constructor
	public Fan(String color, boolean isOn, int speed, double radius) {
		this.speed = speed;
		this.isOn = isOn;
		this.radius = radius;
		this.color = color;
	}
	
	public String toString() {
		String summary = "";
		
		summary += "Fan Speed: " + this.speed + "\n";
		summary += "Fan On: " + this.isOn + "\n";
		summary += "Fan Radius: " + this.radius + "\n";
		summary += "Fan Color: " + this.color + "\n";
		
		return summary;
	}
}

