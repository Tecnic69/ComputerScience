/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * TO DO:
 * 1.) Create a way to decide which event is displayed
 * 		- Second Event constructor + abstract conditions for the event
 * 		- manually set the next used event as a command for a consequence
 * 2.) Decide on a way to run the actual events
 * 		- Method in TextGame class
 * 		- some way in the create(Location)() method
 * 3.) Design a way to store Items and create an Item Storage method to store items
 * 	   in the Plater Inventory
 */

package finalProject;

import java.util.Scanner;

public class TextGame {
	Scanner input = new Scanner(System.in);
	
	public static Location createPrisonWall () {
		Location prisonWall = new Location("There it is, the wall that held me captive for so long");
		
		Event escape = new Event("You finally got over the wall unnoticed... for now.");
		escape.addChoice(new Choice("Search", () -> {System.out.println("You find nothing.");}));
		prisonWall.addEvent(escape);
		
		return prisonWall;
	}
	
	public static void goTo(Location location) {
		
	}
	
	public static void main (String[] args) {
		
		Location prisonWall = createPrisonWall();
	}
}

