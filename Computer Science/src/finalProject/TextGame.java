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
 * 	   in the Player Inventory
 */

package finalProject;

import java.util.Scanner;

public class TextGame {
	static Scanner input = new Scanner(System.in);
		//	Player declaration
	static Character player =  new Character();
	
	static Ammunition arrows = new Ammunition("Arrows", 10);
	
		//	Declared Items - Weapons
	static Weapon oldSword = new Weapon("Old Sword", 5, 7 , 63);
	static Weapon oldAxe = new Weapon("Old Axe", 8, 10, 45);
	static Weapon oldBow = new Weapon("Old Bow", 6, 9, 55, arrows);
	
	
	
		//	Location creation methods
	public static Location createPrisonWall() {
		Location prisonWall = new Location();
		Location forest = createForest();
		
		Event escape = new Event("You finally got over the wall unnoticed... for now.", false);
		escape.addChoice(new Choice("Search", () -> {System.out.println("You find nothing.");}));
		escape.addChoice(new Choice("Wait", () -> {System.out.println("You wait and get captured by the men that kept you captive");System.out.println("Game Over");}));
		escape.addChoice(new Choice("Run", () -> {System.out.printf("You run and run for miles, until you finally see a forest in the distance.\nHopefully you will be able to hide in there.");forest.nextEvent();}));
		
		prisonWall.addEvent(escape);
		
		return prisonWall;
	}
	
	public static Location createForest() {
		Location forest =  new Location();
		
		Event enterCampsite = new Event("As you get deeper into the forest you find a campsite that was abandoned long ago.\nThere are an asortment of items left behind... hopefully one wants them back.\nYou find a jounral and decide to write your name", false);
		enterCampsite.addChoice(new Choice("Write your name in your journal",() -> {System.out.println("Please type your name.");player.setName(input.nextLine());forest.setNextEvent(1);forest.nextEvent();}));
		
		forest.addEvent(enterCampsite);
		
		Event getWeapon = new Event("You also find an old Backpack with a...", false);
		getWeapon.addChoice(new Choice("Axe", () -> {player.addItem(oldAxe);}));
		getWeapon.addChoice(new Choice("Sword", () -> {player.addItem(oldSword);}));
		getWeapon.addChoice(new Choice("A bow with 10 arrows", () -> {player.addItem(oldBow);player.addItem(arrows);}));
		
		forest.addEvent(getWeapon);
		
		
		
		return forest;
	}
	
	public static void goTo(Location location) {
		location.nextEvent();
	}
	
	public static void main (String[] args) {
		
		Location prisonWall = createPrisonWall();
		
		prisonWall.nextEvent();
		
		System.out.println("Thank you for playing!\nThis is all I have at the moment but more will be added soon.");
	}
}

