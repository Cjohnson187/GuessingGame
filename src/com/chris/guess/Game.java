package com.chris.guess;

import java.util.Random;

/**
 * Class to track each game being played, will be multiple instances.
 * @author Chris Johnson
 *
 */
public class Game {
	
	private int userChosenNum;
	private int gameNum; // Probably not needed unless i need to print each game number.
	private int guessCount;
	private int randNum;
	
	/**
	 * Constructor for basic game object to hold number of games and the users number.
	 * @param userChosenNum
	 * @param gameNum
	 */
	public Game(int userChosenNum, int gameNum) {
		this.userChosenNum = userChosenNum;
		this.guessCount = 0;
		this.gameNum = gameNum;
		Random rand = new Random();
		this.randNum = rand.nextInt(userChosenNum);
	}
	
	/**
	 * Method to get the random number for comparison in the game.
	 * @return
	 */
	public int getRandNum() {
		return this.randNum;
	}
	
	/**
	 * Method to get the users chosen number.
	 * @return
	 */
	public int getUserChosenNum() {
		return userChosenNum;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumGuesses() {
		return guessCount;
	}
	
	/**
	 * Method to return the game number for the end of the game.
	 * @return
	 */
	public int getGameNum() {
		return this.gameNum;
	}
	
	/**
	 * Method to increment the number of user guesses before finding the correct random number.
	 */
	public void incrementGuessCount() {
		this.guessCount++;
	}
	
}
