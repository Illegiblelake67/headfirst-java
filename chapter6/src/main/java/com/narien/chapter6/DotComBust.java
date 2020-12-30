package com.narien.chapter6;
import java.util.ArrayList;

import com.narien.chapter5.GameHelper;

public class DotComBust 
{

	GameHelper helper = new GameHelper();
	DotComPlacer placer = new DotComPlacer();
	ArrayList<DotCom> dotComList = new ArrayList();
	int numOfGuesses = 0;
	
	
	void setUpGame() {

		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("Go2.com");
		DotCom three = new DotCom();
		three.setName("AskMe.Com");
		// Add DotCom to the dotComList
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		// Print brief instructions for user
		System.out.println("Your goal is to sink three dot coms");
		System.out.println(one.getName()+ ", "+two.getName()+", "+three.getName());
		System.out.println("Try to sink them all in fewest number of guesses");
		
		//For each element in dotComList
		for (DotCom dotComToSet : dotComList) {
			// Declare and instantiate placer method
			ArrayList<String> newLocation = placer.placeDotCom(3);
			//Call the setter method to 
			dotComToSet.setLocationCells(newLocation);
		}
	}
	void startPlaying() {
		while (!dotComList.isEmpty()) {
			//get user input
			String userGuess = helper.getUserInput("Enter a guess: ");
			// Instantiate checkUserGuess method and pass variable userGuess
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	void checkUserGuess(String userGuess) {
		numOfGuesses++;
		//assume it's a 'miss' unless told otherwise
		String result = "miss";
		// for each loop
		for (DotCom dotComToTest : dotComList) {			
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				dotComList.remove(dotComToTest);
				break;
			}
		}
		// print the result for user
		System.out.println(result);
	}
	void finishGame() {
		System.out.println("Game Over!!");
		
		if (numOfGuesses <= 18) {
			System.out.println("It only took " +numOfGuesses+ " guesses");
			System.out.println("You got out before your options sank.");
		}else {
			System.out.println("Took you long enough. "+numOfGuesses+" guesses");
			System.out.println("Fish are dancing with your options.");
		}
		
	}

    public static void main( String[] args ) {
    	// create game object 
    	DotComBust game = new DotComBust();
    	// tell game object to setup game
    	game.setUpGame();
    	// tell the game object to start main game play loop (keeps asking for user input and checking the guess)
    	game.startPlaying();
    	
    }
}
