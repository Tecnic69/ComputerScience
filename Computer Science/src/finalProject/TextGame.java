/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * TO DO:
 * 1.) Create a default inventory Event
 * 		- Display Inventory
 * 		- Discard Items
 * 		- Exit Inventory
 * 2.) Integrate Discard Item if inventory is to full
 */

package finalProject;

import java.util.Scanner;

import finalProject.CharacterObjects.*;
import finalProject.CharacterObjects.Character;
import finalProject.Locations.*;

public class TextGame {
	static Scanner input = new Scanner(System.in);
		//	Declared Ammunition - Ammunition("Name" , amount)
	static Ammunition arrows = new Ammunition("Arrows", 10);
	
		//	Declared Items - Weapons("Name" , minDamage, maxDamage, hit%)
	static Weapon cane = new Weapon("Cane", 1, 3, 35);
	static Weapon oldSword = new Weapon("Old Sword", 5, 7 , 63);
	static Weapon oldAxe = new Weapon("Old Axe", 8, 10, 45);
	static Weapon oldBow = new Weapon("Old Bow", 6, 9, 55, arrows);
	
		//	Main Player declaration
	public static Character player =  new Character(false);
		
								//	---Character Creation Methods---\\
	
		//	Aggressive NPC = Character("Name" , weapon, health)
	public static Character createOldMan() {
		Character oldMan = new Character("Old man", cane, 6, 20);
		
		oldMan.addDialogue("Hello yourng wipper snapper");
		oldMan.addDialogue("...Oh did you say something");
				
		return oldMan;
	}
	
	
								//	---Location Creation Methods---	\\
	public static Location createPrisonWall() {
		Location prisonWall = new Location();
		
		Event escape = new Event("You finally got over the wall unnoticed... for now.", false);
		escape.addChoice(new Choice("Search", () -> {System.out.println("You find nothing.");player.displayDeathEvent();}));
		escape.addChoice(new Choice("Wait", () -> {System.out.println("You wait and get captured by the men that kept you captive");player.displayDeathEvent();}));
		escape.addChoice(new Choice("Run", () -> {System.out.printf("You run and run for miles, until you finally see a forest in the distance.\nHopefully you will be able to hide in there.");createForest().nextEvent(0);}));
		
		prisonWall.addEvent(escape);
		
		return prisonWall;
	}
	
	public static Location createForest() {
		Location forest =  new Location();

			//	Event Index 0
		Event enterCampsite = new Event("As you get deeper into the forest you find a campsite that was abandoned long ago.\nThere are an asortment of items left behind... hopefully one wants them back.\nYou find a journal and decide to write your name", false);
		enterCampsite.addChoice(new Choice("Write your name in your journal",() -> {System.out.println("Please type your name.");player.setName(input.nextLine());forest.nextEvent(1);}));
		
		forest.addEvent(enterCampsite);
			//	Event Index 1
		Event getWeapon = new Event("You also find an old Backpack with a...", false);
		getWeapon.addChoice(new Choice("Axe", () -> {player.addItem(oldAxe);forest.nextEvent(2);}));
		getWeapon.addChoice(new Choice("Sword", () -> {player.addItem(oldSword);forest.nextEvent(2);}));
		getWeapon.addChoice(new Choice("A bow with 10 arrows", () -> {player.addItem(oldBow);player.addItem(arrows);forest.nextEvent(2);}));
		
		forest.addEvent(getWeapon);
			//	Event Index 2
		Event test = new Event("test");
		test.addNPC(createOldMan());
		
		forest.addEvent(test);
		
		return forest;
	}
	
	public static void run() {
		player.setHealth(20);
		player.getStats().setStats();
		Location prisonWall = createPrisonWall();
		prisonWall.nextEvent(0);
		
	}
	
	public static void main (String[] args) {
		run();
	}
	
}

