import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        System.out.println("Enter person details. Press enter without typing anything to finish:");

        while (true) {
            System.out.print("Enter person name (or press enter to finish): ");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                break;
            }

            System.out.print("Enter person surname: ");
            String surname = scanner.nextLine();

            System.out.print("Is the person a student? (yes/no): ");
            String isStudent = scanner.nextLine().toLowerCase();

            if (isStudent.equals("yes")) {
                System.out.print("Enter student GPA: ");
                double gpa = 0.0;

                try {
                    gpa = scanner.nextDouble();

                    if (gpa < 0 || gpa > 4) {
                        System.out.println("Invalid GPA. GPA should be between 0 and 4 inclusive. Defaulting to 0.0.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input for GPA. Please enter a valid number. Defaulting to 0.0.");
                } finally {
                    scanner.nextLine();
                }

                people.add(new Student(name, surname, gpa));
            } else {
                System.out.print("Enter employee position: ");
                String position = scanner.nextLine();

                System.out.print("Enter employee salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                people.add(new Employee(name, surname, position, salary));
            }
        }

        System.out.println("Entered persons:");
        for (Person person : people) {
            System.out.println(person);
        }

        Collections.sort(people);

        System.out.println("Sorted persons by payment amount:");
        for (Person person : people) {
            System.out.println(person + " earns " + person.getPaymentAmount() + " tenge");
        }

        scanner.close();
    }
}