package com.chris.guess;

import java.util.ArrayList;

/**
 * class to store user information, will only need 1 instance.
 * 
 * @author Chris Johnson
 *
 */
public class User {
	private String language;
	private String name;
	private int bestGameNumber;
	private int worstGameNumber = 0;
	// private int numGamesPlayed = 0; //TODO Don't need this if i use the array
	// size.
	private ArrayList<Integer> avgList = new ArrayList<Integer>();

	/**
	 * Constructor for a game object where there will be multiple.
	 * 
	 * @param language
	 * @param name
	 */
	public User(String language, String name) {
		this.language = language;
		this.name = name;
	}

	/**
	 * Best game number setter.
	 * 
	 * @param gameNum
	 */
	public void setbestGameNumber(int gameNum) {
		bestGameNumber = gameNum;
	}

	/**
	 * Worst game number setter.
	 * 
	 * @param gameNum
	 */
	public void setWorstGameNumber(int gameNum) {
		worstGameNumber = gameNum;
	}

	/*
	 * //TODO get rid of this attribute, I can just use the size of the numOf
	 * guesses array.
	 *//**
		 * Increment the number of games played but may not be necessary.
		 */
	/*
	 * public void incrementNumGamesPlayed() { ++numGamesPlayed; }
	 * 
	 * //TODO probably dont need this either
	 *//**
		 * Returning the number of games played for the final results.
		 * 
		 * @return
		 *//*
			 * public int getNumGamesPlayed() { return numGamesPlayed; }
			 */

	/**
	 * Best game number getter.
	 * 
	 * @return
	 */
	public int getBestGameNumber() {
		return bestGameNumber;
	}

	/**
	 * Worst game number getter
	 * 
	 * @return
	 */
	public int getWorstGameNumber() {
		return worstGameNumber;
	}

	/**
	 * User name getter.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * User Language getter.
	 * 
	 * @return
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Add the current games number of guesses until wining to a list for the
	 * average.
	 * 
	 * @param game
	 */
	public void addToAverage(Game game) {
		avgList.add(game.getNumGuesses());
	}

	/**
	 * Get average of guesses from all games played.
	 * 
	 * @return
	 */
	public int getAverage() {
		int avg = 0;
		for (Integer i : avgList) {
			avg += i;
		}
		avg = avg / avgList.size();
		return avg;
	}

	/**
	 * Update the stats from each game to store best and worst games.
	 * 
	 * @param game
	 */
	public void updateStats(Game game) {
		if (worstGameNumber == 0) {
			worstGameNumber = game.getNumGuesses();
		}
		if (bestGameNumber == 0) {
			bestGameNumber = game.getNumGuesses();
		}

		if (game.getNumGuesses() > worstGameNumber) {
			worstGameNumber = game.getNumGuesses();
		}
		if (game.getNumGuesses() < bestGameNumber) {
			bestGameNumber = game.getNumGuesses();
		}
	}

	public String toStringStats() {
		return "You played " + avgList.size() + " games." + "\n" + "Of those games your best game took "
				+ bestGameNumber + " tries and your worst game took " + worstGameNumber + " tries \n"
				+ "Your average number of guesses for every game is " + getAverage() + "." + "\n\n"
				+ "Thanks for playing!";
	}
}
