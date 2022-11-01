/*
 * Author: Neumann Davila
 * Date:   Oct 13, 2022
 * Description:
 * Ammunition class that allows me to create and use ammo with ranged weapons
 *
 * 
 */

package finalProject.CharacterObjects;

public class Ammunition extends Item {
	private int amount;
	private String name;
	
	public String getName() {
		return this.name;
	}
	public void addAmmo(int amountAdded) {
		this.amount += amountAdded;
	}
	public boolean useAmmo() {
		if (amount > 0) {
			amount--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String summary = "";
		
		summary += name + ": " + amount;
		
		return summary;
	}
	
	public Ammunition(String name, int amount) {
		this.amount = amount;
		this.name = name;
	}
}

