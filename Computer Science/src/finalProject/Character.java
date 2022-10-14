/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Stores Player Data --> Name; Health; Inventory; Stats?
 *
 * 
 */

package finalProject;

public class Character {
	private String name;
	private int health = 20;
	private Item[] inventory = new Item[8];
	private int lastEmptyCell = 0;
		//	store items in this inventory
	
	public void adjustHealth(int userIn) {
		this.health += userIn;
	}
	
	public void addItem(Item newItem) {
		this.inventory[this.lastEmptyCell] = newItem;
		this.lastEmptyCell += 1;
	}
	public void displayInventory() {
		for (int i = 0; i < 8; i++) {
			System.out.println(this.inventory[i]);
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character() {
	}
	
}

