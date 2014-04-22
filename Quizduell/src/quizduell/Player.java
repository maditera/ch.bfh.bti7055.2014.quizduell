package quizduell;

/**
 * A player is defined by a name
 */
public class Player {

    private final String playerName;

    /**
     * Constructor for a player
     *
     * @param userName Name of the player
     */
    public Player(String userName) {
        this.playerName = userName;
    }

    /**
     * Get the name of a player
     *
     * @return a player's name
     */
    public String getPlayerName() {
        return this.playerName;
    }
}