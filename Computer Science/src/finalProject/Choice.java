package finalProject;
/*
 * Author: Neumann Davila
 * Date:   Oct 7, 2022
 * Description:
 *
 *
 * 
 */



public class Choice {
	private String choiceDescription;
	private Consequence outcome;
		//	runs whatever effect is assigned to the react() method
	public void choiceRun() {
		outcome.react();
	}
	
	public void displayChoice() {
		System.out.println(choiceDescription);
	}
		//	Collects info necissary for the Choice
	public Choice(String choiceDescription, Consequence effect) {
		this.choiceDescription = choiceDescription;
		this.outcome = effect;
	}
}

