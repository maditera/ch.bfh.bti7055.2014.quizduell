package quizduell;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The duel manages information like involved players, scores, current player,
 * current round, questions and more
 */
public class Duell {

	private final int ROUNDS_PER_DUELL = 6;
	private final int QUESTIONS_PER_ROUND = 3;

	private int duellID;
	private Player player1;
	private Player player2;
	private int scorePlayer1;
	private int scorePlayer2;
	private int currentRound;
	private DuellStatus currentStatus;
	private ArrayList<Question> duellQuestions;

	/**
	 * Constructor for a duel
	 * 
	 * @param duellID
	 *            Unique duel ID evaluated by the game
	 * @param player1
	 *            current player
	 * @param player2
	 *            chosen opponent player
	 */
	public Duell(int duellID, Player player1, Player player2) {
		this.duellID = duellID;
		this.player1 = player1;
		this.player2 = player2;
		this.scorePlayer1 = 0;
		this.scorePlayer2 = 0;
		this.currentRound = 1;
		this.currentStatus = DuellStatus.PLAYER1;
		this.selectRandomQuestions();
	}

	/**
	 * Generate the Question output for a round
	 */
	public void playRound(Scanner inputScanner) {

		// Get questions for a round and handle answer
		for (int i = 0; i < (this.currentRound * QUESTIONS_PER_ROUND); i++) {

			Question currentQuestion = duellQuestions.get(i);
			System.out.println(currentQuestion.toString());

			char answer;
			do {
				System.out.print("Please choose a valid answer: ");
				String input = inputScanner.nextLine();
				answer = input.toUpperCase().charAt(0);
			} while (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D');

			switch (answer) {

			case 'A':
				this.handleAnswerInput(currentQuestion, 0);
				break;

			case 'B':
				this.handleAnswerInput(currentQuestion, 1);
				break;

			case 'C':
				this.handleAnswerInput(currentQuestion, 2);
				break;

			case 'D':
				this.handleAnswerInput(currentQuestion, 3);
				break;
			}
		}

		// Increase round counter if both player played the round
		if (this.currentStatus == DuellStatus.PLAYER2) {
			this.currentRound++;
		}

		// Switch player
		this.switchPlayer();

		// Check if round limit is reached
		if (this.currentRound == ROUNDS_PER_DUELL+1) {
			this.currentRound = 0;
			this.currentStatus = DuellStatus.FINISHED;
		}
	}

	/**
	 * Check whether an answer is correct or not
	 * 
	 * @param currentQuestion
	 *            Question that should be checked
	 * @param answerPosition
	 *            Identifier for chosen answer
	 */
	private void handleAnswerInput(Question currentQuestion, int answerPosition) {
		if (currentQuestion.checkAnswer(answerPosition)) {
			this.addScore();
			System.out.println("\nCorrect Answer!");
		} else {
			System.out.println("\nWrong Answer!");
		}
	}

	/**
	 * Switch the player
	 */
	private void switchPlayer() {
		if (this.currentStatus == DuellStatus.PLAYER1) {
			this.currentStatus = DuellStatus.PLAYER2;
		} else {
			this.currentStatus = DuellStatus.PLAYER1;
		}
	}

	/**
	 * Add score according to current player
	 */
	private void addScore() {
		if (this.currentStatus == DuellStatus.PLAYER1) {
			this.scorePlayer1++;
		} else {
			this.scorePlayer2++;
		}
	}

	/**
	 * Select random questions from question pool
	 */
	private void selectRandomQuestions() {
		QuestionPool pool = new QuestionPool();
		this.duellQuestions = pool.getQuestionSet(ROUNDS_PER_DUELL * QUESTIONS_PER_ROUND);

	}

	@Override
	public String toString() {
		return "Duell " + this.duellID + " // " + this.player1.getPlayerName() + " - " + this.player2.getPlayerName() + " // " + this.scorePlayer1 + " - "
				+ this.scorePlayer2 + " // " + "Round: " + this.currentRound + " // " + "Status: " + this.currentStatus;
	}

	/**
	 * @return Player First player of a duel
	 */
	public Player getPlayer1() {
		return this.player1;
	}

	/**
	 * @return Player Second player of a duel
	 */
	public Player getPlayer2() {
		return this.player2;
	}

	/**
	 * @return Unique identifier of a duel
	 */
	public int getDuellID() {
		return this.duellID;
	}

	/**
	 * @return Status of a duel
	 */
	public DuellStatus getCurrentStatus() {
		return this.currentStatus;
	}

	/**
	 * Check if a duel has been finished
	 * 
	 * @return True if duel has not been finished, otherwise false
	 */
	public boolean notFinished() {
		if (this.currentStatus != DuellStatus.FINISHED) {
			return true;
		}
		return false;
	}
}