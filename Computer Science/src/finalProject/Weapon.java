/*
 * Author: Neumann Davila
 * Date:   Oct 6, 2022
 * Description:
 *	Used to create WeaponObjects 
 *
 * 
 */

package finalProject;

import java.util.Random;

public class Weapon {
	private int damageMin;
	private int damageMax;
	private boolean isRanged;
	private String name;
	
	public int attack() {
		Random rand = new Random();
		return rand.nextInt(damageMax - damageMin) + damageMin;
		
	}
	
	public Weapon(String name, int damageMin, int damageMax, boolean isRanged) {
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.isRanged = isRanged;
		this.name = name;
	}
	
	public void displayStats() {
		System.out.println(name + ": " + damageMin + "-" + damageMax);
	}
	
}

