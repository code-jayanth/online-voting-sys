import java.util.Scanner;

/**
 * Main class: Entry point for the Online Voting System.
 * Handles menu navigation and user input for both admin and voter roles.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VotingSystem votingSystem = new VotingSystem();

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Voting System!");
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Voter Registration");
            System.out.println("3. Voter Login");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    voterRegistration();
                    break;
                case 3:
                    voterLogin();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void adminMenu() {
        System.out.print("Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Admin Password: ");
        String password = scanner.nextLine();

        if (votingSystem.adminLogin(username, password)) {
            System.out.println("Admin login successful!");
            while (true) {
                System.out.println("\n=== Admin Menu ===");
                System.out.println("1. Add Candidate");
                System.out.println("2. Delete Candidate");
                System.out.println("3. View All Candidates");
                System.out.println("4. Start Voting Session");
                System.out.println("5. End Voting Session");
                System.out.println("6. View Live Results");
                System.out.println("7. View Final Results");
                System.out.println("8. Logout");
                System.out.print("Choose an option: ");
                int choice = getIntInput();

                switch (choice) {
                    case 1:
                        System.out.print("Enter candidate name: ");
                        String name = scanner.nextLine();
                        votingSystem.addCandidate(name);
                        break;
                    case 2:
                        System.out.print("Enter candidate ID to delete: ");
                        int id = getIntInput();
                        votingSystem.deleteCandidate(id);
                        break;
                    case 3:
                        votingSystem.viewCandidates();
                        break;
                    case 4:
                        votingSystem.startVotingSession();
                        break;
                    case 5:
                        votingSystem.endVotingSession();
                        break;
                    case 6:
                        votingSystem.viewLiveResults();
                        break;
                    case 7:
                        votingSystem.viewFinalResults();
                        break;
                    case 8:
                        System.out.println("Admin logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private static void voterRegistration() {
        System.out.print("Enter voter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter voter password: ");
        String password = scanner.nextLine();
        votingSystem.registerVoter(name, password);
    }

    private static void voterLogin() {
        System.out.print("Enter voter ID: ");
        int id = getIntInput();
        System.out.print("Enter voter password: ");
        String password = scanner.nextLine();

        Voter voter = votingSystem.voterLogin(id, password);
        if (voter != null) {
            System.out.println("Voter login successful!");
            if (!votingSystem.isVotingActive()) {
                System.out.println("Voting session is not active.");
                return;
            }
            if (voter.hasVoted()) {
                System.out.println("You have already voted.");
                return;
            }
            votingSystem.viewCandidates();
            System.out.print("Enter candidate ID to vote for: ");
            int candidateId = getIntInput();
            votingSystem.castVote(voter, candidateId);
        } else {
            System.out.println("Invalid voter credentials.");
        }
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getIntInput();
        }
    }
}