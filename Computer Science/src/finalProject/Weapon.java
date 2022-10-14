/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Used to create WeaponObjects 
 * 
 * 
 */

package finalProject;

import java.util.Random;

public class Weapon extends Item {
	private int damageMin;
	private int damageMax;
	private int hitChance;
	private boolean isRanged = false;
	private String name;
	private Ammunition ammo;
	
		//	creates an attack using random values between the min and max
	public int attack() {
		Random rand = new Random();
		
		if (isRanged == false) {
			return rand.nextInt(damageMax - damageMin) + damageMin;
		}
		else {
			if (ammo.useAmmo() == true) {
				return rand.nextInt(damageMax - damageMin) + damageMin;
			}
			else {
				System.out.println("You do not have any ammo for that weapon.");
				return 0;
			}
		}
	}
		//	display's stats of the weapon
	public void displayStats() {
		System.out.println(name + ": " + damageMin + "-" + damageMax);
	}
		//	contstructor intakes: name, damageMin/max, and the hit chance (out of 100)
	public Weapon(String name, int damageMin, int damageMax, int hitChance) {
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.hitChance = hitChance;
		this.name = name;
	}

	public Weapon(String name, int damageMin, int damageMax, int hitChance, Ammunition ammo) {
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.name = name;
		this.isRanged = true;
		this.ammo = ammo;
	}
	
	public String toString() {
		String summary = "";
		
		summary += name + ":\n";
		summary += "     Damage: " + damageMin + " - " + damageMax + "\n";
		summary += "     Hit Chance: " + hitChance + "%";
		
		if (isRanged == true) {
			summary += "\n     Ammo: " + ammo.getName();
		}
		
		return summary;
	}
}

