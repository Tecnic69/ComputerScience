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
				getDecision();
			}
				//	Choices will be run stating at 1 for ease of use
				//	only if default choices are not being used
			else {
				System.out.println(description);
				
				for(int i = 1; i < eventChoices.size() + 1; i++) {
					System.out.println(i + ": " + eventChoices.get(i - 1));
				}
				
				eventChoices.get(input.nextInt() - 1).choiceRun();
			}
		}
	}
	
		//	Inventory event built into every event object if the method is called
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
	
								//	---NPC Methods---	\\
	
	public void addNPC(Character character) {
		eventNPC.add(character);
		addChoice(new Choice("Interact with " + character, () -> {NPCEvent(character);}));
	}
	
	public void NPCEvent(Character NPC) {
		ArrayList<Choice> NPCChoices = new ArrayList<Choice>();
		
		NPCChoices.add(new Choice("Talk to " + NPC, () -> {}));
		NPCChoices.add(new Choice("Attack " + NPC, () -> {combatEvent(NPC);}));
		NPCChoices.add(new Choice("Pickpocket " + NPC, () -> {}));
		
		for (int i = 1; i < NPCChoices.size() + 1;i++ ) {
			System.out.println(i + ": " + NPCChoices.get(i - 1));
		}
		NPCChoices.get(input.nextInt() - 1).choiceRun();
	}
	
		//	Method that runs combat Events with NPC's
	
	public void combatEvent(Character enemy) {
		ArrayList<Choice> combatChoices = new ArrayList<Choice>();
		
			//while both the enemy and the player have over m0 health
		while(TextGame.player.getHealth() > 0 && enemy.getHealth() > 0) {
			System.out.println("\nHealth: " + TextGame.player.getHealth());
			
			combatChoices.add(new Choice("Attack: " + TextGame.player.getEquippedWeapon(), () -> {TextGame.player.attack(enemy);enemy.attack(TextGame.player);}));
			combatChoices.add(new Choice("Switch Weapons", () -> {TextGame.player.setEquippedWeapon();}));
			
			for (int i = 1; i < combatChoices.size() + 1;i++ ) {
				System.out.println(i + ": " + combatChoices.get(i - 1));
			}
			
			combatChoices.get(input.nextInt() - 1).choiceRun();
			
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
		eventChoices.get(input.nextInt()).choiceRun();
	}
	
									//	---Constructors---	\\
	
	public Event(String description) {
		this.description = description;
		eventChoices.add(new Choice("Show Inventory", () -> {inventoryEvent();}));
	}
		//	Special Constructor for events without default choice like Display Inventory
	public Event(String description, boolean containsDefaultChoices) {
		this.description = description;
		this.isDefault = containsDefaultChoices;
	}
}

