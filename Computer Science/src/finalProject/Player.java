/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Stores Player Data --> Name; Health; Inventory; Stats?
 *
 * 
 */

package finalProject;

import java.util.Scanner;

public class Player {
	private String name;
	private int health = 20;
	private Item[] inventory = new Item[8];
		//	store items in this inventory
	
	public void adjustHealth(int userIn) {
		this.health += userIn;
	}
	
	public void addItem(Item newItem) {
		
	}
	public Player(String name) {
		this.name = name;
	}
	
}

