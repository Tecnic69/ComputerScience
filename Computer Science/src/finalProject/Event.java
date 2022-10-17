/*
 * Author: Neumann Davila
 * Date:   Oct 7, 2022
 * Description:
 * Creates an event that can relate to a specific area.
 *
 * 
 */

package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Event {
	private Scanner input = new Scanner(System.in);
	
	private String description;
	private ArrayList<Choice> eventChoices = new ArrayList<Choice>();
	private boolean defaultChoice = true;
	private Character enemy;
	private  Location currentLocation;
	private int nextEventIndex;
	
	
									//	---Display Methods---	\\
	
	public void displayEvent() {
			//	if no enemy is provided then the normal Event structure is followed
		if(enemy == null) {
			System.out.printf(description);
			System.out.println("");
			
			for (int i = 1; i < eventChoices.size() + 1;i++ ) {
				System.out.println(i + ": " + eventChoices.get(i - 1));
			}
			getDecision();
		}
			//	if an enemy is provided then the event is a combat event and runs the following
		else {
			System.out.println(description);
			
			int currentHealth = enemy.getHealth();
				//while both the enemy and the player have over m0 health
			while(TextGame.player.getHealth() > 0 && enemy.getHealth() > 0) {
				System.out.println("\nHealth: " + TextGame.player.getHealth());
				
				addChoice(new Choice("1: Attack: " + TextGame.player.getEquippedWeapon(), () -> {TextGame.player.attack(enemy);}));
				System.out.println(eventChoices.get(0));
				addChoice(new Choice("2: Switch Weapons", () -> {TextGame.player.setEquippedWeapon();}));
				System.out.println(eventChoices.get(1));
				
				getDecision();
				
				while(eventChoices.size() != 0) {
					eventChoices.remove(0);
				}
				
				if(currentHealth != enemy.getHealth()) {
					enemy.attack(TextGame.player);
				}
			}
			if(TextGame.player.getHealth() == 0) {
				System.out.println("\nYou died");
			}
			else {
				System.out.println("\nYou killed the " + enemy);
				currentLocation.nextEvent(nextEventIndex);
			}
			
		}
	}
	
	public void combatEvent() {
		
	}
	
	public void inventoryEvent() {
		ArrayList<Choice> inventoryChoices = new ArrayList<Choice>();
		inventoryChoices.add(new Choice("Discard Item", () -> {TextGame.player.discradItem();displayEvent();}));
		inventoryChoices.add(new Choice("Exit Inventory", () -> {displayEvent();}));
		
		TextGame.player.displayInventory();
		
		System.out.println("What would you like to do in your Inventory?");
		
		for (int i = 1; i < inventoryChoices.size() + 1;i++ ) {
			System.out.println(i + ": " + inventoryChoices.get(i - 1));
		}
		inventoryChoices.get(input.nextInt() - 1).choiceRun();
	}
	
									//	---Choice Methods---  \\
	public void addChoice(Choice choice) {
		this.eventChoices.add(choice);
	}
		//	Collects and runs the decision for the event 
	public void getDecision() {
		eventChoices.get(input.nextInt() - 1).choiceRun();
		
	}
	
									//	---Constructors---  \\
	
		//	Basic Event Constructor
	public Event(String description) {
		this.description = description;
		eventChoices.add(new Choice("Show Inventory", () -> {inventoryEvent();}));
	}
		//	Special Constructor for events without default choice like Display Inventory
	public Event(String description, boolean containsDefaultChoices) {
		this.description = description;
		this.defaultChoice = containsDefaultChoices;
	}
		//	Constructor for combat Events
	public Event(String description, ArrayList<Character> characters) {
		this.description = description;
	}
	
}

