package quizduell;

/**
 * The simulation contains the main method to create and run a game instance
 */
class QuizduellLauncher {

    /**
     * Main method to run the game
     *
     * @param args are not used
     */
    public static void main(String[] args) {

        QuizduellGame game = new QuizduellGame();

        // Create players
        game.newPlayer("kilchhofer");
        game.newPlayer("lauper");
        game.newPlayer("schmutz");

        QuizduellUI menu = new QuizduellUI(game);
        menu.run();
    }
}
