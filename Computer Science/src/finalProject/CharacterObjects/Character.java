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
	private int maxHealth = 0;
	private int tempHealth;
		//	Stat Manager
	private StatManager stats = new StatManager();
		//	inventory variables
	private int lastEmptyCell = 0;
	private Item[] inventory = new Item[8];
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private Weapon equippedWeapon = null;	
		//	death events
	private Event death;
		
										//	---MISC---  \\
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
	
	public StatManager getStats() {
		return stats;
	}	
	
	
								//	---Health Methods---  \\
	
	public String healthBar() {
		return tempHealth + " / " + maxHealth;
	}
	
	public void adjustMaxHealth(int adjustment) {
		maxHealth += adjustment;
		tempHealth = maxHealth;
	}
	public void setMaxHealth(int health) {
		this.maxHealth = health;
		this.tempHealth = maxHealth;
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
			
			System.out.println("You do " + damage + " + " + extra +  " damage to the " + enemy + ".");
			
		}
		else {
			System.out.println("You miss!");
		}	
	}
	
	public void setDeathEvent(Event event) {
		this.death = event;
	}
	public Event getDeathEvent() {
		return this.death;
	}
	
	public void displayDeathEvent() {
		death.displayEvent();
	}
	
								//	---Weapon Methods---  \\
	
	public Item getItem(int index) {
		return inventory[index];
	}
	
	public Weapon getEquippedWeapon() {
		return this.equippedWeapon;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return this.weapons;
	}
	
	public void setEquippedWeapon(Weapon weapon) {
		equippedWeapon = weapon;
	}
	
	public void EquipWeapon() {

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
	
								//	---Inventory Methods---  \\
	
		
		//	Adds a general item to the inventory
	public void addItem(Item newItem) {
		if(lastEmptyCell < 8) {
			this.inventory[this.lastEmptyCell] = newItem;
			this.lastEmptyCell += 1;
			
			if(newItem instanceof Weapon) {
				weapons.add((Weapon) newItem);
				if(weapons.size() == 1) {
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
				removeItem(discardIndex);
			}
			else {
				discardItem();
			}
		}
		else if(discardIndex == 9) {
			
		}
		else {
			System.out.println("Invalid Input");
			discardItem();
		}
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
			if (tempInput == 1) {
				recipiant.addItem(inventory[discardIndex - 1]);
				removeItem(discardIndex);
				
				cycleInventory();
			}
		}
		else if(discardIndex == 9) {
			
		}
		else {
			System.out.println("Invalid Input");
			giveItem(recipiant);
		}
	}
	
	public void pickPocket(Character recipiant) {
			//	finalize stat system idea
			//	create an if statement that allows for a chance of failure
		if(recipiant.getStats().rollDexterity(this.stats.getDexterity()) == true) {
			displayInventory();
			System.out.println("What would you like to take?\n9: Exit");
			int stealIndex = input.nextInt();
			
			if(stealIndex < 9 || stealIndex > 0) {
				recipiant.addItem(inventory[stealIndex - 1]);
				removeItem(stealIndex);
				
				cycleInventory();
			}
			else if (stealIndex == 9) {
				
			}
			else {
				System.out.println("Invalid Input");
				pickPocket(recipiant);
			}
		}
		else {
			System.out.println("Failed");
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
	
	public void removeItem(int index) {
		if(inventory[index - 1] instanceof Weapon) {
			inventory[index - 1] = null;
			weapons.remove(inventory[index - 1]);
			
			EquipWeapon();
		}
		else {
			inventory[index - 1] = null;
		}
		
		cycleInventory();
	}
								//	---Constructors---  \\}
	
	public Character() {
		Event gameOver = new Event("You Died", false);
		gameOver.addChoice(new Choice("Restart Game", () -> {TextGame.run();}));
		setDeathEvent(gameOver);
		this.stats.getXp().setStat(0);
	}
	
}

