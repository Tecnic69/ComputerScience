/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 * This program is going to create location objects so that I can acces them in my text adventure game
 * 
 * 
 */

package finalProject;

public class Location {
	private String description;
	private int numChoices;
	private int choiceIndex = 0;
	private String[] choices;
	
		 // Method displays information when the character arrives at this location
	public void arrive() {
		int i;
		
		System.out.println(this.description);
		
		for (i = 0; i < numChoices; i++) {
			System.out.println((i) + ": " +choices[i]);
		}
		
		System.out.println((i++) + ": Quit");
	}
		//	Collects the name/action that is displayed 
	public void getChoices(String name) {
		choices[choiceIndex] = name;
	}
	
		//	Object Constructor
	public Location(String description, int numChoices) {
		this.description = description;
		this.numChoices = numChoices;
		this.choices = new String[numChoices];
	}

}

