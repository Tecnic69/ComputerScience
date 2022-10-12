/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * TO DO:
 * 1.) Create a way to decide which event is displayed
 * 		- Second Event constructor + abstract conditions for the event
 * 		- manually set the next used event as a command for a consequence <------
 * 2.) run game
 * 		- Method in TextGame class
 * 		- some way in the create(Location)() method
 * 3.) Design a way to store Items and create an Item Storage method to store items
 * 	   in the Plater Inventory
 */

package finalProject;

import java.util.Scanner;

public class TextGame {
	Scanner input = new Scanner(System.in);
	
	static Player bobert =  new Player();
	
	public static Location createPrisonWall() {
		Location prisonWall = new Location();
		Location forest = createForest();
		
		Event escape = new Event("You finally got over the wall unnoticed... for now.");
		escape.addChoice(new Choice("Search", () -> {System.out.println("You find nothing.");}));
		escape.addChoice(new Choice("Wait", () -> {System.out.println("You wait and get captured by the men that kept you captive");System.out.println("Game Over");}));
		escape.addChoice(new Choice("Run", () -> {System.out.println("You run and run for miles, until you finally see a forest in the distance. Hopefully you will be able to hide in there.");forest.nextEvent();}));
		
		prisonWall.addEvent(escape);
		
		return prisonWall;
	}
	
	public static Location createForest() {
		Location forest =  new Location();
		
		Event enter = new Event("As you get deeper into the forest you can see");
		
		forest.addEvent(enter);
		
		return forest;
	}
	public static void goTo(Location location) {
		location.nextEvent();
	}
	public static void main (String[] args) {
		
		Location prisonWall = createPrisonWall();
		Location forest = createForest();
		
		prisonWall.nextEvent();
	}
}

