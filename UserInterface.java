package tracker;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private LearningTracker learningTracker;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.learningTracker = new LearningTracker();
    }

    public void start() {
        System.out.println("Learning Progress Tracker");
        boolean userWantToExit = false;

        while (!userWantToExit) {
            String userInput = scanner.nextLine().trim().toLowerCase();
            switch (userInput) {
                case "add students" -> {
                    this.learningTracker.addStudent();
                }
                case "exit" -> {
                    System.out.println("Bye!");
                    userWantToExit = true;
                }
                case "" -> {
                    System.out.println("No input.");
                }
                case "back" -> {
                    System.out.println("Enter 'exit' to exit the program.");
                }
                default -> {
                    System.out.println("Error: unknown command!");
                }
            }
        }
    }

}
