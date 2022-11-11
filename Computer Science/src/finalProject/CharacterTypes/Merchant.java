/*
 * Author: Neumann Davila
 * Date:   Nov 8, 2022
 * Description:
 *
 *
 * 
 */

package finalProject.CharacterTypes;

import java.util.ArrayList;
import java.util.Scanner;

import finalProject.TextGame;
import finalProject.Items.*;
import finalProject.Locations.Choice;
import finalProject.Locations.Event;

public class Merchant extends NPC {
	private String shopName;
	private ArrayList<Item> forSale = new ArrayList<Item>();
	private boolean open;
	
	public boolean isOpen() {
		return open;
	}
	
	public void setOpen(boolean isOpen) {
		this.open = isOpen;
	}
	
	public void addSale(Item item) {
		forSale.add(item);
	}
	
	public String getShopName() {
		return shopName;
	}

	public Merchant() {
		super();
		this.shopName = "Test";
	}
	
	public Merchant(String name, String shopName, int health, int xp) {
		this.name = name;
		adjustMaxHealth(health);
		stats.getXp().adjustStat(xp);
		this.shopName = shopName;
	}
}

