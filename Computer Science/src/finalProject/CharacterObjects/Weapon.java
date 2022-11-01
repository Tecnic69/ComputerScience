/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 * Used to create WeaponObjects 
 * 
 * 
 */

package finalProject.CharacterObjects;

import java.util.Random;

public class Weapon extends Item {
	private int damageMin;
	private int damageMax;
	private int hitChance;
	private boolean isRanged = false;
	private String name;
	private Ammunition ammo;
	
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
		//	creates an attack using random values between the min and max
	public int attack() {
		Random rand = new Random();
		int hitPerc = rand.nextInt(99);
		
		if(hitPerc < hitChance - 1){
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
		else {
			return 0;
		}
	}
	
											//	---Constructors---  \\
	public Weapon() {
		this.name = "test";
		this.damageMax = 2;
		this.damageMin = 1;
		this.hitChance = 50;
	}
		
	public Weapon(String name, int damageMin, int damageMax, int hitChance) {
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.hitChance = hitChance;
		this.name = name;
	}

	public Weapon(String name, int damageMin, int damageMax, int hitChance, Ammunition ammo) {
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.hitChance = hitChance;
		this.name = name;
		this.isRanged = true;
		this.ammo = ammo;
	}
	
	
}

