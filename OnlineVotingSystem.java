import java.util.Scanner;

public class OnlineVotingSystem {

    static Scanner sc = new Scanner(System.in);

    static String[] candidates = {
            "Alice",
            "Bob",
            "Charlie"
    };

    static int[] votes = {0, 0, 0};

    static boolean[] voted = new boolean[100];

    static final String ADMIN_USERNAME = "admin";
    static final String ADMIN_PASSWORD = "1234";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== ONLINE VOTING SYSTEM ==========");
            System.out.println("1. Cast Vote");
            System.out.println("2. View Candidates");
            System.out.println("3. Admin Login (View Results)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    castVote();
                    break;

                case 2:
                    displayCandidates();
                    break;

                case 3:
                    adminLogin();
                    break;

                case 4:
                    System.out.println("Thank you for using Online Voting System.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // Display Candidates
    static void displayCandidates() {
        System.out.println("\n------ Candidates ------");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println((i + 1) + ". " + candidates[i]);
        }
    }

    // Cast Vote
    static void castVote() {

        System.out.print("\nEnter your Voter ID (1-99): ");
        int voterId = sc.nextInt();

        if (voterId < 1 || voterId > 99) {
            System.out.println("Invalid Voter ID!");
            return;
        }

        if (voted[voterId]) {
            System.out.println("You have already voted!");
            return;
        }

        displayCandidates();

        System.out.print("Choose Candidate Number: ");
        int candidate = sc.nextInt();

        if (candidate < 1 || candidate > candidates.length) {
            System.out.println("Invalid Candidate!");
            return;
        }

        votes[candidate - 1]++;
        voted[voterId] = true;

        System.out.println("Vote Cast Successfully!");
    }

    // Admin Login
    static void adminLogin() {

        System.out.print("\nEnter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        if (username.equals(ADMIN_USERNAME) &&
                password.equals(ADMIN_PASSWORD)) {

            displayResults();

        } else {

            System.out.println("Invalid Username or Password!");

        }
    }

    // Display Results
    static void displayResults() {

        System.out.println("\n====== ELECTION RESULTS ======");

        int maxVotes = -1;
        String winner = "";

        for (int i = 0; i < candidates.length; i++) {

            System.out.println(candidates[i] + " : " + votes[i] + " votes");

            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = candidates[i];
            }
        }

        System.out.println("------------------------------");
        System.out.println("Winner: " + winner);
    }
}