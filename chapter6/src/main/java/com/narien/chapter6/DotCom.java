package com.narien.chapter6;

import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> locationCells;
	String name;
	
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;

    }

    public String checkYourself(String userInput){
        int index = locationCells.indexOf(userInput);
        String result = "miss";
        
        if( index >= 0) {
        	locationCells.remove(index);
        }
        	
        if (locationCells.isEmpty()) {
            result = "kill";
            System.out.println("Ouch! You Sank " +name+ ":");
        }else {
        	
        }
        System.out.println(result);
        return result;

    }
}
