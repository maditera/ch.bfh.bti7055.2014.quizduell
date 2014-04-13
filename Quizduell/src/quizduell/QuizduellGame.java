package quizduell;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The game provides methods to manage multiple players and duels
 *
 */
public class QuizduellGame {

	private ArrayList<Duell> allDuells;
	private ArrayList<Player> allPlayers;
	private ArrayList<Player> possibleOpponents;

	private Player currentPlayer;
	private Duell currentDuell;
	private boolean loggedIn;

	/**
	 * Constructor for a new game that initializes the instance variables
	 */
	public QuizduellGame() {

		this.allDuells = new ArrayList<Duell>();
		this.allPlayers = new ArrayList<Player>();
		this.possibleOpponents = new ArrayList<Player>();

		this.currentPlayer = null;
		this.currentDuell = null;
		this.loggedIn = false;
	}

	/**
	 * Login an existing player
	 * @param playerName Name of the player that should be logged in
	 * @return login status
	 */
	public boolean login(String playerName) {
		for (Player player : this.allPlayers) {
			if (player.getPlayerName().equals(playerName)) {
				this.currentPlayer = player;
				this.loggedIn = true;
				this.setPossibleOpponents();
				return true;
			}
		}
		return false;
	}

	/**
	 * Logout a logged in player
	 */
	public void logout() {
		this.currentPlayer = null;
		this.loggedIn = false;
	}

	/**
	 * Check the current login status
	 * @return the current login status
	 */
	public boolean getLoginStatus() {
		return this.loggedIn;
	}

	/**
	 * Create a new duel for the logged in player against a specific opponent and ad it to the duel list
	 * @param opponentName Name of the wished opponent
	 */
	public void newDuell(String opponentName, Scanner inputScanner) {
		Player opponentPlayer = null;
		for (Player player : this.allPlayers) {
			if (player.getPlayerName().equals(opponentName)) {
				opponentPlayer = player;
			}

		}
		Duell newDuell = new Duell(this.allDuells.size() + 1,
				this.currentPlayer, opponentPlayer);
		this.allDuells.add(newDuell);
		this.currentDuell = newDuell;
		this.currentDuell.playRound(inputScanner);
		
	}

	/**
	 * Create a new player and add it to the player list
	 * @param playerName Name of the new player
	 */
	public void newPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.allPlayers.add(newPlayer);
	}

	/**
	 * Set a list of all possible opponents for the current player
	 */
	public void setPossibleOpponents() {
		this.possibleOpponents.clear();
		for (Player player : this.allPlayers) {
			if (!this.currentPlayer.equals(player)) {
				this.possibleOpponents.add(player);
			}
		}
	}

	/**
	 * Gather information about all possible opponents
	 * @return Formatted list of all possible opponents
	 */
	public String getPossibleOpponents() {
		String opponentsList = "";
		for (Player player : this.possibleOpponents) {
			opponentsList = opponentsList + player.getPlayerName() + "\n";
		}
		return opponentsList;
	}

	/**
	 * Check if i chosen opponent name is valid
	 * @param playerName Name of desired opponent
	 * @return True if valid opponent, false if invalid opponent
	 */
	public boolean validateOpponent(String playerName) {
		for (Player player : this.possibleOpponents) {
			if (player.getPlayerName().equals(playerName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gather information about all players of a game
	 * @return Formatted list containing all players in a game
	 */
	public String getAllPlayers() {
		String playerList = "";
		for (Player player : this.allPlayers) {
			playerList = playerList + player.getPlayerName() + "\n";
		}
		return playerList;

	}
	
	/**
	 * Search for all duels in which a specific player is involved
	 * @param player Specific player object
	 * @return List of duel objects assigned to specific user
	 */
	public ArrayList<Duell> getAPlayerDuells(Player player) {
		ArrayList<Duell> APlayersDuells = new ArrayList<Duell>();
		for (Duell duell: this.allDuells) {
			if (duell.getPlayer1().equals(player) || duell.getPlayer2().equals(player)) {
				APlayersDuells.add(duell);
			}
		}
		return APlayersDuells;
	}
	
	/**
	 * Check if a certain duel can be played by the current player
	 * @param duellID Unique duel identifier shown to the player
	 * @return True if certain duel can be played, false if not
	 */
	public boolean validateDuell(int duellID) {
		Duell duellToValidate;
		
		for (Duell duell: this.allDuells) {
			if (duell.getDuellID() == duellID) {
				duellToValidate = duell;
				if (duellToValidate.notFinished()     ) {
					
					if ((duellToValidate.getCurrentStatus() == DuellStatus.PLAYER1) && (duellToValidate.getPlayer1().equals(this.currentPlayer))) {
						return true;
					}
					else if ((duellToValidate.getCurrentStatus() == DuellStatus.PLAYER2) && (duellToValidate.getPlayer2().equals(this.currentPlayer))) {
						return true;
					}
				}
			} 
		} 
		return false;
	}

	/**
	 * Load a specific duel and play a round
	 * @param duellID Unique duel identifier shown to the player
	 */
	public void continueDuell(int duellID, Scanner inputScanner) {
		for (Duell duell : this.allDuells) {
			if (duell.getDuellID() == duellID) {
				 this.currentDuell = duell;
				 this.currentDuell.playRound(inputScanner);
			}
		}
	}
	
	/**
	 * Gather information about all duels involving the current player
	 * @return Formatted list of all duels involving the current player
	 */
	public String displayDuells() {
		String duellList = "";
		ArrayList<Duell> duellsToDisplay = this.getAPlayerDuells(currentPlayer);
		for (Duell duell : duellsToDisplay) {
				duellList = duellList + duell.toString() + "\n";
		}
		return duellList;
	}

}
