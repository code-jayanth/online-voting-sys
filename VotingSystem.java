import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * VotingSystem class: Manages the core business logic, including candidates, voters,
 * voting session state, and results. Uses in-memory storage.
 */
public class VotingSystem {
    private final List<Candidate> candidates = new ArrayList<>();
    private final List<Voter> voters = new ArrayList<>();
    private final Map<Integer, Integer> voteCounts = new HashMap<>(); // Candidate ID -> Vote count
    private boolean isVotingActive = false;
    private int nextVoterId = 1;
    private int nextCandidateId = 1;

    // Admin login (hardcoded for demo)
    public boolean adminLogin(String username, String password) {
        return "admin".equals(username) && "admin123".equals(password);
    }

    // Voter registration
    public void registerVoter(String name, String password) {
        Voter voter = new Voter(nextVoterId++, name, password);
        voters.add(voter);
        System.out.println("Voter registered successfully. Your ID is: " + voter.getId());
    }

    // Voter login
    public Voter voterLogin(int id, String password) {
        for (Voter voter : voters) {
            if (voter.getId() == id && voter.getPassword().equals(password)) {
                return voter;
            }
        }
        return null;
    }

    // Add candidate
    public void addCandidate(String name) {
        Candidate candidate = new Candidate(nextCandidateId++, name);
        candidates.add(candidate);
        voteCounts.put(candidate.getId(), 0);
        System.out.println("Candidate added: " + name);
    }

    // Delete candidate
    public void deleteCandidate(int id) {
        candidates.removeIf(candidate -> candidate.getId() == id);
        voteCounts.remove(id);
        System.out.println("Candidate deleted.");
    }

    // View all candidates
    public void viewCandidates() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }
        System.out.println("Candidates:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getId() + ". " + candidate.getName());
        }
    }

    // Start voting session
    public void startVotingSession() {
        if (isVotingActive) {
            System.out.println("Voting session is already active.");
            return;
        }
        isVotingActive = true;
        System.out.println("Voting session started.");
    }

    // End voting session
    public void endVotingSession() {
        if (!isVotingActive) {
            System.out.println("Voting session is not active.");
            return;
        }
        isVotingActive = false;
        System.out.println("Voting session ended.");
    }

    // Check if voting is active
    public boolean isVotingActive() {
        return isVotingActive;
    }

    // Cast vote
    public void castVote(Voter voter, int candidateId) {
        if (!isVotingActive) {
            System.out.println("Voting session is not active.");
            return;
        }
        if (voter.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }
        if (!voteCounts.containsKey(candidateId)) {
            System.out.println("Invalid candidate ID.");
            return;
        }
        voteCounts.put(candidateId, voteCounts.get(candidateId) + 1);
        voter.setHasVoted(true);
        System.out.println("Vote cast successfully for candidate ID: " + candidateId);
    }

    // View live results (during voting)
    public void viewLiveResults() {
        if (!isVotingActive) {
            System.out.println("Voting session is not active.");
            return;
        }
        System.out.println("Live Results:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + voteCounts.get(candidate.getId()) + " votes");
        }
    }

    // View final results (after voting ends)
    public void viewFinalResults() {
        if (isVotingActive) {
            System.out.println("Voting session is still active. End it first.");
            return;
        }
        System.out.println("Final Results:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + voteCounts.get(candidate.getId()) + " votes");
        }
    }
}