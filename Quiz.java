// Keagan Morrison 2022

import java.util.Scanner;

public class Quiz {
    //Categories and Questions
    public static void main(String[] args) throws Exception {
        Category Ferrari = new Category("Ferrari",
                "you are a loud and proud go-getter who refuses to let anything get in the way of your goals");
        Category Lamborghini = new Category("Lamborghini",
                "you are sly and smooth, acting with swagger and moving with finesse at every turn");
        Category Mercedes = new Category("Mercedes", "you're a traditional person who revels in the classics");
        Category Tesla = new Category("Tesla",
                "you are obsessed with progress and the advancement of technology, refusing to stick to traditions in favor of something more efficient");
        Question Q1 = new Question("Of these words how would you describe yourself?");
        Q1.possibleAnswers[0] = new Answer("Tenacious", Ferrari);
        Q1.possibleAnswers[1] = new Answer("Slick", Lamborghini);
        Q1.possibleAnswers[2] = new Answer("Original", Mercedes);
        Q1.possibleAnswers[3] = new Answer("Progressive", Tesla);
        Question Q2 = new Question("What state do you see yourself in the future");
        Q2.possibleAnswers[0] = new Answer("State? Im leaving America!", Ferrari);
        Q2.possibleAnswers[1] = new Answer("Flawda", Lamborghini);
        Q2.possibleAnswers[2] = new Answer("West virginia", Mercedes);
        Q2.possibleAnswers[3] = new Answer("California", Tesla);
        Question Q3 = new Question("Hypothetically, out of these animals, which would you like to keep as a pet");
        Q3.possibleAnswers[0] = new Answer("Big cats(Lions, Panthers, etc.)", Ferrari);
        Q3.possibleAnswers[1] = new Answer("Birds", Lamborghini);
        Q3.possibleAnswers[2] = new Answer("Dogs", Mercedes);
        Q3.possibleAnswers[3] = new Answer("Monkeys", Tesla);
        Question Q4 = new Question("Which shape would you best describe yourself as");
        Q4.possibleAnswers[0] = new Answer("Triangle(im so cool)", Ferrari);
        Q4.possibleAnswers[1] = new Answer("Circle", Lamborghini);
        Q4.possibleAnswers[2] = new Answer("Square", Mercedes);
        Q4.possibleAnswers[3] = new Answer("Dodecahedron", Tesla);
        Question Q5 = new Question("on a scale of 1 to 10 how much did you like this quiz");
        Q5.possibleAnswers[0] = new Answer("7", Ferrari);
        Q5.possibleAnswers[1] = new Answer("4", Lamborghini);
        Q5.possibleAnswers[2] = new Answer("5", Mercedes);
        Q5.possibleAnswers[3] = new Answer("π", Tesla);
// Main code
        Scanner sc = new Scanner(System.in);
        Intro(sc);
        Question[] Qlist = { Q1, Q2, Q3, Q4, Q5 };
        int[] CategoryPoints = { Ferrari.points, Lamborghini.points, Mercedes.points, Tesla.points };
        Category[] Categories = { Ferrari, Lamborghini, Mercedes, Tesla };

        for (Question q : Qlist) {
            Category cycle = q.ask(sc);
            cycle.points++;
        }
//Had trouble saving points
        int Index = PopularIndex(CategoryPoints);
        System.out.println("The results are in; If you were a car, you would be a " + Categories[Index].label);
        System.out.println(Categories[Index].description);

    }

    public static void Intro(Scanner sc) {
        System.out.println("Which car are you, take this quiz to find out!");
        System.out.println("Enter 1 to start");
        int play = sc.nextInt();
        boolean playz = sc.hasNextInt();
        if (play != 1 | playz == false) {
            System.out.println("Wrong key(s), try again!");
            Intro(sc);
        }
        
    }

    public static int PopularIndex(int[] CategoryPoints) {
        int MostPopular = 0;
        int Index = 0;
        for (int i = 0; i < CategoryPoints.length; i++) {
            if (CategoryPoints[i] > MostPopular) {
                MostPopular = CategoryPoints[i];
                Index = i;
            }
        }
        return Index;
    }
}