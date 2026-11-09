
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static PollManager manager = new PollManager();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SIMPLE POLL MANAGEMENT =====");
            System.out.println("1. Administrator");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    adminMenu();
                    break;

                case 2:
                    studentMenu();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void adminMenu() {

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Create Poll");
            System.out.println("2. View Polls");
            System.out.println("3. Close Poll");
            System.out.println("4. View Results");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter question: ");
                    String question = sc.nextLine();

                    System.out.print("Enter number of options: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    if (n < 2) {
                        System.out.println("Enter at least 2 options!");
                        break;
                    }

                    ArrayList<String> options = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter option " + (i + 1) + ": ");
                        options.add(sc.nextLine());
                    }

                    manager.createPoll(question, options);
                    break;

                case 2:
                    manager.displayPolls();
                    break;

                case 3:
                    System.out.print("Enter Poll ID: ");
                    int closeId = sc.nextInt();
                    sc.nextLine();

                    manager.closePoll(closeId);
                    break;

                case 4:
                    System.out.print("Enter Poll ID: ");
                    int resultId = sc.nextInt();
                    sc.nextLine();

                    manager.showResults(resultId);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void studentMenu() {

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. View Polls");
            System.out.println("2. Vote");
            System.out.println("3. View Results");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.displayPolls();
                    break;

                case 2:
                    if (!manager.hasPolls()) {
                        System.out.println("No polls available.");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter Poll ID: ");
                    int pollId = sc.nextInt();
                    sc.nextLine();

                    Poll poll = manager.findPoll(pollId);

                    if (poll == null) {
                        System.out.println("Poll not found!");
                        break;
                    }

                    
                    poll.displayPoll();

                    System.out.print("Select option number: ");
                    int option = sc.nextInt();
                    sc.nextLine();

                    poll.vote(studentId, option);
                    break;

                case 3:
                    System.out.print("Enter Poll ID: ");
                    int resultId = sc.nextInt();
                    sc.nextLine();

                    manager.showResults(resultId);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
