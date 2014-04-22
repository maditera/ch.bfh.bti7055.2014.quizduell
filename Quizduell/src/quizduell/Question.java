package quizduell;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A Question contains a question text and multiple answers
 */
class Question {

    private final String questionText;
    private final ArrayList<Answer> answers = new ArrayList<Answer>();

    /**
     * Constructor for a Question
     *
     * @param questionText  Question text itself
     * @param correctAnswer The correct answer
     * @param wrongAnswer1  First wrong answer
     * @param wrongAnswer2  Second wrong answer
     * @param wrongAnswer3  Third wrong answer
     */
    public Question(String questionText, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.questionText = questionText;
        this.answers.add(new Answer(correctAnswer, true));
        this.answers.add(new Answer(wrongAnswer1, false));
        this.answers.add(new Answer(wrongAnswer2, false));
        this.answers.add(new Answer(wrongAnswer3, false));

    }

    public String toString() {
        ArrayList<Answer> shuffledAnswers = this.answers;
        Collections.shuffle(shuffledAnswers);
        return " \n*** Question ***\n" + this.questionText + "\n" + "A - " + shuffledAnswers.get(0).toString() + "\n" + "B - "
                + shuffledAnswers.get(1).toString() + "\n" + "C - " + shuffledAnswers.get(2).toString() + "\n" + "D - " + shuffledAnswers.get(3).toString();
    }

    /**
     * Check if a specific answer is correct
     *
     * @param answerPosition Chosen answer by player (A = 0, B = 1, C = 2, D = 3)
     * @return True if answer is correct, false if answer is wrong
     */
    public boolean checkAnswer(int answerPosition) {
        return this.answers.get(answerPosition).isCorrect();

    }
}