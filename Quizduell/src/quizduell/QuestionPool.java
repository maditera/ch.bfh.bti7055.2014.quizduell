package quizduell;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionPool {

    ArrayList<Question> allQuestions;

    public QuestionPool() {

        this.allQuestions = new ArrayList<Question>();

        // First answer option must be the correct one
        this.allQuestions.add(new Question("Was ist KEINE Stadt der Schweiz?", "Berlin", "Bern", "Z�rich", "Basel"));
        this.allQuestions.add(new Question("Was ist eine Stadt der Schweiz?", "Biel", "Berlin", "Bamberg", "Bremen"));
        this.allQuestions.add(new Question("Was ist KEIN Teil einer Digitalkamera?", "Sieb", "Linse", "Chip", "Sensor"));
        this.allQuestions.add(new Question("Frage A", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage B", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage C", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage D", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage E", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage F", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage G", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage H", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage I", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage J", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage K", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage L", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage M", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage N", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage O", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage P", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage Q", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage R", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage S", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage T", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage U", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage V", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage W", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage X", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage Y", "richtig", "falsch", "falsch", "falsch"));
        this.allQuestions.add(new Question("Frage Z", "richtig", "falsch", "falsch", "falsch"));
    }

    public ArrayList<Question> getQuestionSet(int numberOfQuestions) {

        ArrayList<Question> allQuestions = this.allQuestions;
        ArrayList<Question> questionSet = new ArrayList<Question>();

        Collections.shuffle(allQuestions);

        for (int i = 0; i < numberOfQuestions; i++) {
            questionSet.add(allQuestions.get(i));
        }
        return questionSet;
    }
}
