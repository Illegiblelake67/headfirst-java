package com.narien.chapter5;


public class SimpleDotComGame {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        //Initiate new object in gameHelper class
        GameHelper helper = new GameHelper();
        //Initiate new object in gameHelper class
        SimpleDotCom theDotCom = new SimpleDotCom();
        // int variable to create random num
        // (int) cast ot be variable type
        // global Math class , Random method
        // * num returns from 0 to less than 1
        int randomNum = (int) (Math.random() * 5);
        int [] locations = {randomNum, randomNum+1, randomNum+2};
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("Enter the number:");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if(result.equals("kill")) {
                isAlive = false;
                System.out.println("you took "+ numOfGuesses + " guesses");
            }
        }


    }
}
