package com.narien.chapter5;

public class SimpleDotCom {
    int [] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;

    }

    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        //enhanced for loop, elements in the array must be compatable with variable type
        // with each iteration different element is assigned to variable name
        // the colon mean IN (:) Array list
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;

    }

}

