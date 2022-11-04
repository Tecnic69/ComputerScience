/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Stores Player Data --> Name; Health; Inventory; Stats?
 *
 * 
 */

package finalProject.CharacterObjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import finalProject.Locations.Event;
import finalProject.Locations.Choice;
import finalProject.TextGame;


public class Character {
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	
	private String name;
	private int maxHealth;
	private int tempHealth;
		//	Stat Manager
	private StatManager stats = new StatManager();
		//	inventory variables
	private int lastEmptyCell = 0;
	private Item[] inventory = new Item[8];
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private Weapon equippedWeapon = null;
		//	npc variables
	private boolean isNPC = true;
	private ArrayList<String> dialogue = new ArrayList<String>();
	private ArrayList<Event> sideQuests = new ArrayList<Event>();
		//	death events
	private Event death = new Event("");
		
										//	---MISC---  \\
	
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
	
										//	---Stats---	\\
	
	public StatManager getStats() {
		return stats;
	}
								  //	---NPC Methods---	\\
	
	
	public void addDialogue(String newDialogue) {
		dialogue.add(newDialogue);
	}
	
	public String getDialogue() {
		return dialogue.get(rand.nextInt((dialogue.size())));
	}
	
	public void addSideQuest(Event newQuest) {
		sideQuests.add(newQuest);
	}
	
	public void giveItem(Character recipiant) {
		displayInventory();
		System.out.println("What Item would you like to give to " + recipiant + "?\n9: Exit");
		int discardIndex = input.nextInt();
		
		if(discardIndex < 9){
			Item tempItem = inventory[discardIndex - 1];
			
			System.out.println("Are you sure you want to give:\n" + tempItem);
			System.out.println("1: Yes\n2: No");
			int tempInput = input.nextInt();
			if (tempInput ==1) {
				recipiant.addItem(inventory[discardIndex - 1]);
				weapons.remove(inventory[discardIndex -1]);
				inventory[discardIndex - 1] = null;
				
				cycleInventory();
								
			}
		}
	}
	
	public void pickPocket(Character recipiant) {
			//	finalize stat system idea
			//	create an if statement that allows for a chance of failure
		if(recipiant.getStats().rollDexterity(this.stats.getDexterity()) == true) {
			displayInventory();
			System.out.println("What would you like to take?\n9: Exit");
			int stealIndex = input.nextInt();
			
			if(stealIndex < 9) {
				recipiant.addItem(inventory[stealIndex - 1]);
				inventory[stealIndex - 1] = null;
				
				cycleInventory();
			}
		}
		else {
			System.out.println("Failed");
		}
	}
	
								//	---Health Methods---  \\
	
	public String healthBar() {
		return tempHealth + " / " + maxHealth;
	}
	
	public void adjustMaxHealth(int adjustment) {
		maxHealth += adjustment;
		tempHealth = maxHealth;
	}
	
	public void setHealth(int health) {
		this.tempHealth = health;
	}
	
	public void adjustHealth(int userIn) {
		this.tempHealth += userIn;
	}
	
	public int getHealth() {
		return this.tempHealth;
	}
	
	public void attack(Character enemy) {
		int damage = equippedWeapon.attack();
		if(damage > 0) {
			int extra = rand.nextInt(stats.getStrength().getStat());
			
			enemy.adjustHealth(-(damage + extra));
			
			if(isNPC == false) {
				System.out.println("You do " + damage + " + " + extra +  " damage to the " + enemy + ".");
			}
			else {
				System.out.println("The " + this.name + " did " + damage + " damage to you.");
			}
		}
		else {
			if(isNPC == false) {
				System.out.println("You miss!");
			}
			else {
				System.out.println(this.name + " missed!");
			}
		}
	}
	
	public void setDeathEvent(Event event) {
		this.death = event;
	}
	
	public void displayDeathEvent() {
		if(isNPC == true) {
			TextGame.player.getStats().addXp(this.stats.getXp().getStat());
		}
		death.displayEvent();
	}
	
								//	---Weapon Methods---  \\
	
	public Item getItem(int index) {
		return inventory[index];
	}
	
	public Weapon getEquippedWeapon() {
		return this.equippedWeapon;
	}
	
	public void setEquippedWeapon() {
		if(isNPC == false) {

			if(weapons.size() == 0) {
				equippedWeapon = new Weapon("Fist", 1, 2, 10);
			}
			else {
				for(int i = 0; i < weapons.size(); i++) {
					System.out.println((i + 1) + ": " + weapons.get(i));
				}
				System.out.println("Choose the weapon you would like to equip:");
				equippedWeapon = weapons.get(input.nextInt() - 1);
			}
		}
		else {
			
			if(weapons.size() == 0) {
				equippedWeapon = new Weapon("Fist", 1, 2, 10);
			}	
		}
	}
	
								//	---Inventory Methods---  \\
		
		//	Adds a general item to the inventory
	public void addItem(Item newItem) {
		if(lastEmptyCell < 8) {
			this.inventory[this.lastEmptyCell] = newItem;
			this.lastEmptyCell += 1;
			
			if(newItem instanceof Weapon) {
				weapons.add((Weapon) newItem);
				if(isNPC == true || weapons.size() == 1) {
					equippedWeapon = (Weapon) newItem;
				}
			}
			
		}
		else {
			System.out.println("You have no space in your inventory!");
		}
	}
	
	public void displayInventory() {
		for (int i = 0; i < lastEmptyCell; i++) {
			System.out.println(1 + i + ": " + this.inventory[i]);
		}
		
			//	---print something fancy in empty inventory slots---
	}
	
	public void discardItem() {
		displayInventory();
		System.out.println("What Item would you like to discard?\n9: Exit");
		int discardIndex = input.nextInt();
		
		if(discardIndex < 9) {
			
			System.out.println("Are you sure you want to discard:\n" + inventory[discardIndex - 1]);
			System.out.println("1: Yes\n2: No");
			if (input.nextInt() == 1) {
				
				if(inventory[discardIndex - 1] instanceof Weapon) {
					inventory[discardIndex - 1] = null;
					weapons.remove(inventory[discardIndex - 1]);
					
					setEquippedWeapon();
				}
				else {
					inventory[discardIndex - 1] = null;
				}
				
				cycleInventory();
				
			}
		}
	}
	
	public void cycleInventory() {
		for(int i = 0; i < lastEmptyCell; i++) {
			if (inventory[i] == null) {
				inventory[i] = inventory[i + 1];
				inventory[i + 1] = null;
			}
		}
		lastEmptyCell--;
	}
	
								//	---Constructors---  \\
	public Character() {
		this.name = "test";
		this.maxHealth = 10;
		addItem(new Weapon());
		this.stats.getXp().setStat(10);
	}
	
	public Character(boolean isNPC) {
		this.isNPC = isNPC;
		this.maxHealth = 20;
		Event gameOver = new Event("You Died", false);
		gameOver.addChoice(new Choice("Restart Game", () -> {TextGame.run();}));
		setDeathEvent(gameOver);
		this.stats.getXp().setStat(0);
	}
	
	public Character(String name, Weapon weapon, int health,int xp) {
		this.name = name;
		this.maxHealth = health;
		this.tempHealth = health;
		addItem(weapon);
		this.stats.getXp().setStat(xp);
	}
}

