/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 * This program is going to create location objects so that I can acces them in my text adventure game
 *
 * 
 */

package finalProject;

import java.util.Scanner;

public class Location {
	private String description;
	private int numChoices;
	
	public void arrive() {
		System.out.println(this.description);
	}
	
	public Location(String description) {
		this.description = description;
	}
	
	public void getNumChoices(int numChoices) {
		this.numChoices = numChoices;
		String[] choices = new String[numChoices];
	}
	public void getChoices(String name) {
		
	}
	
	public void showChoices() {
		for (int i = 0; i <= numChoices; i++) {
			
		}
	}
}

