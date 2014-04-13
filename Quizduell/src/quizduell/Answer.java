package quizduell;

public class Answer {
	
	private String answerText;
	private boolean isCorrect;
	
	public Answer(String answerText, boolean isCorrect) {
		this.answerText = answerText;
		this.isCorrect = isCorrect;
	}
	
	public String toString() {
		return this.answerText;
	}
	
	public boolean isCorrect() {
		return this.isCorrect;
	}
}
