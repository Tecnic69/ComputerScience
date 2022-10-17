/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Stores Player Data --> Name; Health; Inventory; Stats?
 *
 * 
 */

package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Character {
	Scanner input = new Scanner(System.in);
	
	private String name;
	private int health = 20;
		//	inventory variables
	private int lastEmptyCell = 0;
	private Item[] inventory = new Item[8];
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private Weapon equippedWeapon;
		//	npc vairbales
	private boolean isNPC = true;
		//	death events
	private Event death = new Event("");
		
									//	---MISC---  \\
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
	
								//	---Health Methods---  \\
	public void adjustHealth(int userIn) {
		this.health += userIn;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void attack(Character enemy) {
		int damage = equippedWeapon.attack();
		enemy.adjustHealth(-damage);
		
		if(isNPC == false) {
			System.out.println("You do " + damage + " damage to the " + enemy + ".");
		}
		else {
			System.out.println("The " + this.name + " did " + damage + " damage to you.");
		}
	}
	
	public void deathEvent(Event event) {
		death.addChoice(new Choice("", () -> {}));
		
		death.displayEvent();
		event.displayEvent();
	}
	
								//	---Weapon Methods---  \\
	
	//	Adds weapons to a list that can be easily accessed
	public void addItem(Weapon newWeapon) {
		if(lastEmptyCell < 8) {
			weapons.add(newWeapon);
			this.inventory[this.lastEmptyCell] = newWeapon;
			this.lastEmptyCell += 1;
			if (weapons.size() == 1) {
				this.equippedWeapon = newWeapon;
			}
		}
		else {
			System.out.println("You have no space in your inventory!");
		}
	}
	
	public Weapon getEquippedWeapon() {
		return this.equippedWeapon;
	}
	
	public void setEquippedWeapon() {
		for(int i = 0; i < weapons.size(); i++) {
			System.out.println(1 + i + ": " + weapons.get(i));
		}
		System.out.println("Please select a weapon.");
		equippedWeapon = weapons.get(input.nextInt() - 1);
	}
	
								//	---Inventory Methods---  \\
		
		//	Adds a general item to the inventory
	public void addItem(Item newItem) {
		if(lastEmptyCell < 8) {
			this.inventory[this.lastEmptyCell] = newItem;
			this.lastEmptyCell += 1;
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
	
	public void discradItem() {
		displayInventory();
		System.out.println("What Item would you like to discard?\n9: Exit");
		int discardIndex = input.nextInt();
		if(discardIndex == 9) {
			
		}
		else {
			Item tempItem = inventory[discardIndex - 1];
			
			System.out.println("Are you sure you want to discard:\n" + tempItem);
			System.out.println("1: Yes\n2: No");
			int tempInput = input.nextInt();
			if (tempInput ==1) {
				inventory[discardIndex - 1] = null;
				for(int i = 0; i < lastEmptyCell; i++) {
					if (inventory[i] == null) {
						inventory[i] = inventory[i + 1];
						inventory[i + 1] = null;
					}
				}
				lastEmptyCell--;
			}
			else {
				
			}
		}
		
	}
	
								//	---Constructors---  \\
	
	public Character(boolean isNPC) {
		this.isNPC = isNPC;
	}
	
	public Character(String name, Weapon weapon, int health) {
		this.name = name;
		this.health = health;
		addItem(weapon);
	}
}

