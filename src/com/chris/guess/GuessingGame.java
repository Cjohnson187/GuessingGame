package com.chris.guess;


import java.util.*;


class GuessingGame {
	/**
	 * The main method gets the language(not how to internationalize) and name, then creates the user and game objects. 
	 * It then calls the play method that uses recursion to update the counts and check if the guesses are correct
	 * once the guess is correct it breaks back to the main to see if the user wants to play again. 
	 * If the user does not want to play again. It will call the print method from the user object and print out the users game statistics.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Found on java docs Internationalization example
		String language;
		String country;
		if (args.length != 2) {
			language = new String("en");
			country = new String("US");
		} else {
			language = new String(args[0]);
			country =  new String(args[1]);
		}
		
		Locale currentLocale;
		ResourceBundle messages;
		
		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("com.chris.guess.MessagesBundle", currentLocale);
		System.out.println(messages.getString("final1"));
		
		int currentGameNum = 0;
		Scanner input = new Scanner(System.in);
		String[] basicInfo = getBasicInfo(input);
		User player = new User(basicInfo[0], basicInfo[1]);
		
		while (true) {
			int numOfGuesses = 0;
			System.out.println("Please choose a number for the game to get a random number between 0 and your number.");
			int userNum = input.nextInt();
			Game currentGame = new Game(userNum, currentGameNum);
			play(currentGame, input, numOfGuesses, player);
			player.updateStats(currentGame);
			input.nextLine();
			System.out.println("Would you like to play again?  \nType yes or no. \n");
			String response = input.nextLine();
		
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

}