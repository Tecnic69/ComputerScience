/*
 * Author: Neumann Davila
 * Date:   Oct 7, 2022
 * Description:
 * Events Store multiple things necissary for the program
 * 		- Event description
 * 		- Choices custom to the event
 * 		- Default Events that can run in every event conditionaly
 * 		- NPC's within the event and the interactions that are possible with that npc
 * 			- This is build in so it is easier to return back to this event (may change)
 * 
 * 
 */

package finalProject.Locations;

import java.util.ArrayList;
import java.util.Scanner;

import finalProject.CharacterObjects.Character;
import finalProject.CharacterObjects.NPC;
import finalProject.CharacterObjects.Item;

import finalProject.TextGame;

public class Event {
	private Scanner input = new Scanner(System.in);
	
	private String description;
	private ArrayList<Choice> eventChoices = new ArrayList<Choice>();
	private ArrayList<Character> eventNPC = new ArrayList<Character>();
	private boolean isDefault = true;
	
									//	---Display Methods---	\\
	
	public void displayEvent() {
			//	automatically runs if there is only one choice in the Event
		if(eventChoices.size() == 1) {
			System.out.println(description);
			eventChoices.get(0).choiceRun();
		}
		else {
				//	If the event has default choices then it will run starting at 0
			if(isDefault == true) {
				System.out.printf(description);
				System.out.println("");
				
				for (int i = 0; i < eventChoices.size();i++ ) {
					System.out.println(i + ": " + eventChoices.get(i));
				}
				try {
					eventChoices.get(input.nextInt()).choiceRun();
					}
					catch(Exception e){
						System.out.println("Invalid input");
						displayEvent();
					}
			}
				//	Choices will be run stating at 1 for ease of use
				//	only if default choices are not being used
			else {
				System.out.println(description);
				
				for(int i = 1; i < eventChoices.size() + 1; i++) {
					System.out.println(i + ": " + eventChoices.get(i - 1));
				}
				
				getDecision();
			}
		}
	}
	
		//	Inventory event built into every event object if the method is called
	public void inventoryEvent() {
		ArrayList<Choice> inventoryChoices = new ArrayList<Choice>();
		inventoryChoices.add(new Choice("Discard Item", () -> {TextGame.player.discardItem();displayEvent();}));
		inventoryChoices.add(new Choice("Change Equipped Weapon", () -> {TextGame.player.EquipWeapon();}));
		inventoryChoices.add(new Choice("Exit Inventory", () -> {displayEvent();}));
		
		TextGame.player.displayInventory();
		
		System.out.println("What would you like to do in your Inventory?");
		
		for(int i = 1; i < inventoryChoices.size() + 1;i++ ) {
			System.out.println(i + ": " + inventoryChoices.get(i - 1));
		}
		try {
			inventoryChoices.get(input.nextInt() - 1).choiceRun();
			}
			catch(Exception e){
				System.out.println("Invalid input");
				inventoryEvent();
			}
		
		displayEvent();
	}
	
								//	---NPC Methods---	\\
	
	public void addNPC(NPC character) {
		eventNPC.add(character);
		addChoice(new Choice("Interact with " + character, () -> {NPCEvent(character);displayEvent();}));
	}
	
	public void NPCEvent(NPC NPC) {
		ArrayList<Choice> NPCChoices = new ArrayList<Choice>();
		TextGame.player.getStats().interact(NPC);
		NPCChoices.add(new Choice("Talk to " + NPC, () -> {System.out.println(NPC.getDialogue());}));
		NPCChoices.add(new Choice("Give something to " + NPC, () -> {TextGame.player.giveItem(NPC);}));
		NPCChoices.add(new Choice("Attack " + NPC, () -> {combatEvent(NPC);}));
		NPCChoices.add(new Choice("Pickpocket " + NPC, () -> {NPC.pickPocket(TextGame.player);}));
		
		for (int i = 1; i < NPCChoices.size() + 1;i++ ) {
			System.out.println(i + ": " + NPCChoices.get(i - 1));
		}
		try {
			NPCChoices.get(input.nextInt() - 1).choiceRun();
			
			}
			catch(Exception e){
				System.out.println("Invalid input");
				NPCEvent(NPC);
			}	}
	
		//	Method that runs combat Events with NPC's
	
	public void combatEvent(Character enemy) {
		ArrayList<Choice> combatChoices = new ArrayList<Choice>();
		
			//while both the enemy and the player have over 0 health
		while(TextGame.player.getHealth() > 0 && enemy.getHealth() > 0) {
			System.out.println("\nHealth: " + TextGame.player.healthBar());
			
			combatChoices.add(new Choice("Attack: " + TextGame.player.getEquippedWeapon(), () -> {TextGame.player.attack(enemy);enemy.attack(TextGame.player);}));
			combatChoices.add(new Choice("Switch Weapons", () -> {TextGame.player.EquipWeapon();}));
			combatChoices.add(new Choice("Use your surroundings", () -> {}));
			
			for (int i = 1; i < combatChoices.size() + 1;i++ ) {
				System.out.println(i + ": " + combatChoices.get(i - 1));
			}
			
			try {
				combatChoices.get(input.nextInt() - 1).choiceRun();
				}
				catch(Exception e){
					System.out.println("Invalid input");
					combatEvent(enemy);
				}	
			System.out.println(enemy.healthBar());
			while(combatChoices.size() != 0) {
				combatChoices.remove(0);
			}
		}
		if(TextGame.player.getHealth() < 0) {
			TextGame.player.displayDeathEvent();
		}
		else {
			System.out.println("\nYou killed the " + enemy);
			enemy.displayDeathEvent();
		}
		
	}
	
	
									//	---Choice Methods---  \\

	public void addChoice(Choice choice) {
		this.eventChoices.add(choice);
	}
		//	Collects and runs the decision for the event 
	public void getDecision() {
		try {
		eventChoices.get(input.nextInt() - 1).choiceRun();
		}
		catch(Exception e){
			System.out.println("Invalid input");
			displayEvent();
		}
			
	}
	
									//	---Constructors---	\\
	
	public Event() {
		this.description = "test";
		eventChoices.add(new Choice("Show Inventory", () -> {inventoryEvent();}));
		addNPC(new NPC());
	}
	
	public Event(String description) {
		this.description = description;
		eventChoices.add(new Choice("Show Inventory", () -> {inventoryEvent();}));
	}
		//	Special Constructor for events without default choice like Display Inventory
	public Event(String description, boolean containsDefaultChoices) {
		this.description = description;
		this.isDefault = containsDefaultChoices;
	}
	
	public Event(String description, Item triggerItem) {
		this.description = description;
	}
}

