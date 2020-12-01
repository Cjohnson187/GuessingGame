package com.chris.guess;

import com.chris.guess.User;
import com.chris.guess.Game;

import java.util.ArrayList;
import java.util.Scanner;


class GuessingGame {
	
	/**
	 * The main method 
	 * @param args
	 */
	public static void main(String[] args) {
		int currentGameNum = 0; //TODO prob not needed is i use the user object size of guess Array.
		Scanner input = new Scanner(System.in);
		String[] basicInfo = getBasicInfo(input);
		User player = new User(basicInfo[0], basicInfo[1]);
		ArrayList<Game> savedGames = new ArrayList<Game>();
		
		while (true) {
			//player.incrementNumGamesPlayed();
			int numOfGuesses = 0; // i don't think i need this because the game object tracks number of guesses.
			
			System.out.println("Please choose a number for the game to get a random number between 0 and your number.");
			int userNum = input.nextInt();
			Game currentGame = new Game(userNum, currentGameNum);
			play(currentGame, input, numOfGuesses, player);
			
			//savedGames.add(currentGame); //TODO dont need it
			
			player.updateStats(currentGame);
			input.nextLine();
			System.out.println("Would you like to play again?  \nType yes or no. \n");
			String response = input.nextLine();
			
			System.out.println(response); // testing next line
			
			if (response.equals("no")) {
				break;
			}
			else if(response.equals("yes")) {
				continue;
			}
			else {
				System.out.println("Sorry I did not understand your response, exiting game...");
				break;
			}
			
		}
		System.out.println(player.toStringStats());
		input.close();
		
	}
	
	/**
	 * Method to get basic user info like language and name.
	 * @param input
	 * @return
	 */
	public static String[] getBasicInfo(Scanner input) {
		String[] basicInfo = new String[2];
		System.out.println("Get ready to play the guessing game?");
		
		/*
		 * 		*probably need internationalization before this in separate file of strings
		 */
		System.out.println("\nPlease Type your language and press enter.");
		basicInfo[0] = input.nextLine(); // language
		System.out.println("\nPlease Type your name and press enter.");
		basicInfo[1] = input.nextLine(); // name
		
		return basicInfo;
	}
	
	/**
	 * Play the guessing game with the user using recursion.
	 * @param game
	 */
	public static void play(Game game, Scanner input, int numGuesses, User user) {
		System.out.println("Guess a number between 0 and " + game.getUserChosenNum());
		int currentGuess = input.nextInt();
		if (currentGuess == game.getRandNum()) {
			game.incrementGuessCount();
			System.out.println("YOU WIN!");
			user.addToAverage(game);
			return;
		}
		else if (currentGuess < game.getRandNum() ) {
			game.incrementGuessCount();
			System.out.println("Sorry that number is too low, please try again.");
			play(game, input, game.getNumGuesses(), user);
		}
		else if (currentGuess > game.getRandNum()) {
			game.incrementGuessCount();
			System.out.println("Sorry that number is too high, please try again.");
			play(game, input, game.getNumGuesses(), user);
		}
		else {
			System.out.println("Something seems to have gone wrong, please try again.");
			play(game, input, game.getNumGuesses(), user);
		}
	}
			

	
	/**
	 * Method to update players stats with last game played.
	 * @param currentGame
	 */
	public static void printStats() {
		System.out.println();
	}
	
	

}