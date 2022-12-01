import java.util.Scanner;

public class Question {
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    Category ask(Scanner sc) {
        System.out.println(this.label);

        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        int ans = sc.nextInt();
        if(ans>4 || ans<1) {
            ask(sc);
        }
        return possibleAnswers[ans - 1].cat;

    }

}
