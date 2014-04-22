package quizduell;

/**
 * An answer has an answer text and a true/false value
 */
public class Answer {

    private String answerText;
    private boolean isCorrect;

    /**
     * Constructor for an answer
     *
     * @param answerText The answer text
     * @param isCorrect  Indicator whether an answer is correct or not
     */
    public Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return this.answerText;
    }

    /**
     * Check whether an answer is correct or not
     *
     * @return True if answer is correct, false if answer is wrong
     */
    public boolean isCorrect() {
        return this.isCorrect;
    }
}
