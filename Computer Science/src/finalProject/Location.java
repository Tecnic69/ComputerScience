/*
 * Author: Neumann Davila
 * Date:   Oct 4, 2022
 * Description:
 * This program is going to create location objects so that I can access them in my text adventure game
 * 
 * 
 */

package finalProject;

import java.util.ArrayList;

public class Location {
	private ArrayList<Event> locationEvents =  new ArrayList<Event>();
	private int nextEventIndex = 0;
	
		 // Method displays information when the character arrives at this location
	public void addEvent(Event newEvent) {
		locationEvents.add(newEvent);
	}
	public void setNextEvent(int eventNum) {
		this.nextEventIndex = eventNum;
	}
		//	create a way to get the next event by yourself loser
	public void nextEvent() {
		Event tempEvent = locationEvents.get(nextEventIndex);
		tempEvent.displayEvent();
		tempEvent.getDecision();
	}
		
		//	Object Constructor
	public Location() {
	}

}

