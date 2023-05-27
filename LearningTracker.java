package tracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LearningTracker {
    private ArrayList<Student> students;
    private Scanner scanner;

    public LearningTracker() {
        this.scanner = new Scanner(System.in);
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Objective of the method is to add students, the string must meet certain conditions in order to be added:
     * <p>
     * 1- The firstNamePattern it accepts a string that doesn't start with any special character, and it has to contain at least 2 characters
     * it can contain '-' or ' between the name, but not at the start or at the end of it.
     * <p>
     * 2- The lastNamePattern it acts the same as the firstNamePattern, but it can have any whitespace between them.
     * <p>
     * 3- The emailPattern explains itself.
     */
    public void addStudent() {
        String studentFirstNamePattern = ("^[A-Za-z][-']?[A-Za-z]+(?:[-'][A-Za-z]+)*$");
        String studentLastNamePattern = ("^(?!.*(?:--|''|-'|'-))[a-zA-Z][a-zA-Z'-]*[a-zA-Z](?:\\s[a-zA-Z][a-zA-Z'-]*[a-zA-Z])*$");
        String emailPattern = ("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
        StringBuilder sbLastName = new StringBuilder();
        int studentsAdded = 0;


        System.out.println("Enter student credentials or 'back' to return");
        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("back")) {
                System.out.printf("Total %d students have been added.\n", studentsAdded);
                return;
            } else {
                String[] splitUserInput = userInput.split(" ");

                if (splitUserInput.length < 3) {
                    System.out.println("Incorrect credentials.");
                    continue;
                }

                if (!splitUserInput[0].matches(studentFirstNamePattern)) {
                    System.out.println("Incorrect first name.");
                    continue;
                }

                for (int i = 1; i <= splitUserInput.length - 2; i++) {
                    sbLastName.append(splitUserInput[i]).append(" ");
                }

                //Removing last space from the StringBuilder before checking lastName
                sbLastName.deleteCharAt(sbLastName.length() - 1);

                if (!sbLastName.toString().matches(studentLastNamePattern)) {
                    System.out.println("Incorrect last name.");
                    sbLastName.setLength(0);
                    continue;
                }

                if (!splitUserInput[splitUserInput.length - 1].matches(emailPattern)) {
                    System.out.println("Incorrect email.");
                    continue;
                }

                String firstName = splitUserInput[0];
                String lastName = sbLastName.toString();
                String email = splitUserInput[splitUserInput.length - 1];

                this.addStudent(new Student(firstName, lastName, email));
                studentsAdded++;
                System.out.println("The student has been added.");

                //Clearing the StringBuilder
                sbLastName.setLength(0);
            }
        }

    }

    public int sizeListStudents() {
        return this.students.size();
    }

}
