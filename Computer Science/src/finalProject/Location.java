/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 * This program is going to create location objects so that I can acces them in my text adventure game
 * 
 * 
 */

package finalProject;

import java.util.ArrayList;

public class Location {
	private String description;
	private ArrayList<Event> locationEvents =  new ArrayList<Event>();
	
	public void arrive() {
		System.out.printf(description);
	}
		 // Method displays information when the character arrives at this location
	public void addEvent(Event newEvent) {
		locationEvents.add(newEvent);
	}
		//	create a way to get the next event by yourself loser
	public Event nextEvent() {
		
	}
		
		//	Object Constructor
	public Location(String description) {
		this.description = description;
	}

}

