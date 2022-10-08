/*
 * Author: Neumann Davila
 * Date:   Oct 7, 2022
 * Description:
 * Creates an event that can relate to a specific area.
 *
 * 
 */

package finalProject;

import java.util.ArrayList;
import java.util.Scanner;


public class Event {
	private Scanner input = new Scanner(System.in);
	private ArrayList<Choice> eventChoices = new ArrayList<Choice>();
	private String description;

	
	public void addChoice(Choice choice) {
		this.eventChoices.add(choice);
	}
		//	Displays all the choices that are available for the event
	public void displayEvent() {
		System.out.println(description);
		
		for (int i = 1; i < eventChoices.size() + 1;i++ ) {
			Choice tempChoice = eventChoices.get(i);
			System.out.print(i + ": ");
			tempChoice.displayChoice();
		}
	}

		//	Collects and runs the decision for the event 
	public void getDecision() {
		Choice tempChoice = eventChoices.get(input.nextInt());
		tempChoice.choiceRun();
	}
	public Event(String description) {
		this.description = description;
	}
}

