package quizduell;

import java.util.Scanner;

/**
 * The UI provides methods to display outputs and handle user inputs
 */
public class QuizduellUI {

	
	private QuizduellGame game;
	private boolean runGame;
	private Scanner inputScanner;

	/**
	 * Constructor for UI
	 * @param game Game object that the UI is working with
	 */
	public QuizduellUI(QuizduellGame game) {
		
		this.game = game;
		this.inputScanner = new Scanner(System.in);
	}

	/**
	 * Run the game controlled by a loop
	 */
	public void run() {
		this.runGame = true;
		while (runGame) {
			this.showMenu();
			this.handleUserInput();
		}
	}

	/**
	 * Print the menu options
	 */
	public void showMenu() {
		System.out
				.println("Log I)n N)ew Duel C)ontinue Duel D)isplay Duels Log O)ut Q)uit");
		System.out.print("Choose an option: ");
	}

	/**
	 * Perform further action according to the users input
	 */
	public void handleUserInput() {
		
		String input = inputScanner.nextLine();
		
		if (input != null && !input.isEmpty()) {
			
			char command = input.toUpperCase().charAt(0);
			
			switch (command) {
			
			// Log in
			case 'I':
				System.out.print("Player name: ");
				String playerName = inputScanner.nextLine();
				if (game.login(playerName)) {
					System.out.println("Login successful");
				} else {
					System.out.println("Invalid player");
				}
				break;

			// Create new duell
			case 'N':
				if (game.getLoginStatus()) {
					System.out.println("Available opponents: ");
					System.out.println(game.getPossibleOpponents());
					System.out.print("Opponent's name: ");
					String opponentName = inputScanner.nextLine();
					if (game.validateOpponent(opponentName)) {
						game.newDuell(opponentName, inputScanner);
					} else {
						System.out.println("Please choose a valid opponent");
						break;
					}
				} else {
					System.out.println("Please login first");
				}
				break;

			// Continue existing duell
			case 'C':

				if (game.getLoginStatus()) {
					System.out.print("Enter duell number: ");
					int duellID = inputScanner.nextInt();
					if (game.validateDuell(duellID)) {
						game.continueDuell(duellID, inputScanner);
					} else {
						System.out
								.println("Please choose a valid duell. It should be your turn and it should not be finished.");
					}
				} else {
					System.out.println("Please login first");
				}
				break;

			// Display existing duells
			case 'D':
				if (game.getLoginStatus()) {
					System.out.println(game.displayDuells());
				} else {
					System.out.println("Please login first");
				}
				break;

			// Log out
			case 'O':
				if (game.getLoginStatus()) {
					game.logout();
					System.out.println("Logged out");
				} else {
					System.out
							.println("No action performed because you were not logged in");
				}
				break;

			// Quit game
			case 'Q':
				this.runGame = false;
				break;

			default:
				System.out.println("Please choose a valid option");
				break;
			}
		}
		input = "";
	}
}
