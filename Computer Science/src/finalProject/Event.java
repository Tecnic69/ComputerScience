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
	
									//	---Display Methods---	\\
	
	public void displayEvent() {
			//	if no enemy is provided then the normal Event structure is followed
		
			System.out.printf(description);
			System.out.println("");
			for (int j = 0; j < eventNPC.size(); j++) {
				Character NPC = eventNPC.get(j);
				addChoice(new Choice("" + eventNPC.get(j), () -> {NPCEvent(NPC);}));
			}
			for (int i = 0; i < eventChoices.size();i++ ) {
				System.out.println(i + ": " + eventChoices.get(i));
			}
			
			for (int j = 0; j < eventNPC.size(); j++) {
				Character NPC = eventNPC.get(j);
				addChoice(new Choice("" + eventNPC.get(j), () -> {NPCEvent(NPC);}));
			}
			
			getDecision();
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
	
								//	---NPC Methods---	\\
	
	public void addNPC(Character character) {
		eventNPC.add(character);
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
	
	public void combatEvent(Character enemy) {
		ArrayList<Choice> combatChoices = new ArrayList<Choice>();
		
		int currentHealth = enemy.getHealth();
			//while both the enemy and the player have over m0 health
		while(TextGame.player.getHealth() > 0 && enemy.getHealth() > 0) {
			System.out.println("\nHealth: " + TextGame.player.getHealth());
			
			combatChoices.add(new Choice("Attack: " + TextGame.player.getEquippedWeapon(), () -> {TextGame.player.attack(enemy);}));
			combatChoices.add(new Choice("Switch Weapons", () -> {TextGame.player.setEquippedWeapon();}));
			
			for (int i = 1; i < combatChoices.size() + 1;i++ ) {
				System.out.println(i + ": " + combatChoices.get(i - 1));
			}
			
			combatChoices.get(input.nextInt() - 1).choiceRun();
			
			while(combatChoices.size() != 0) {
				combatChoices.remove(0);
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
			//	enemy.deathEvent();
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
	}
}

