/*
 * Author: Neumann Davila
 * Date:   Nov 4, 2022
 * Description:
 *
 *
 * 
 */

package finalProject.CharacterObjects;

import java.util.ArrayList;

import finalProject.TextGame;
import finalProject.Locations.Event;

public class NPC extends Character {

	private ArrayList<String> dialogue = new ArrayList<String>();
	private ArrayList<Event> sideQuests = new ArrayList<Event>();
	
								//	----Interaction---	\\
	
	public void addDialogue(String newDialogue) {
		dialogue.add(newDialogue);
	}
	
	public String getDialogue() {
		return dialogue.get(rand.nextInt((dialogue.size())));
	}
	
	public void addSideQuest(Event newQuest) {
		sideQuests.add(newQuest);
	}
	
								//	---Misc---	\\
	
	@Override public void attack(Character enemy) {
		int damage = getEquippedWeapon().attack();
		if(damage > 0) {
			int extra = rand.nextInt(getStats().getStrength().getStat());
			
			enemy.adjustHealth(-(damage + extra));
			
			System.out.println("The " + getName() + " did " + damage + " damage to you.");
		}
		else {
				System.out.println(getName() + " missed!");
		}
	}
		
	@Override public void EquipWeapon() {
		if(getWeapons().size() == 0) {
			setEquippedWeapon(new Weapon("Fist", 1, 2, 10));
		}
		else if (getWeapons().size() == 1){
			setEquippedWeapon(getWeapons().get(0));
		}
		else {
			//	cycling through weapons or attack type
		}
	}
	
	@Override public void displayDeathEvent() {
		TextGame.player.getStats().addXp(getStats().getXp().getStat());
		displayDeathEvent();
	}
	
	
	public NPC() {
		super();
	}
	
	public NPC(String name, Weapon weapon, int health, int xp) {
		setName(name);
		addItem(weapon);
		adjustMaxHealth(health);
		getStats().getXp().setStat(xp);
	}
}

