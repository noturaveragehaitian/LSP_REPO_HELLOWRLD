package org.howard.edu.lsp.midterm.question3;
import java.util.HashMap;
import java.util.Map;
// referencing ChatGPT
public class VotingMachine {
	// HashMap to store candidates and their votes
    private Map<String, Integer> candidates;

    public VotingMachine() {
        // Initialize the HashMap
        candidates = new HashMap<>();
    }

    // Add a new candidate
    public void addCandidate(String name) {
        // Check if candidate already exists
        if (!candidates.containsKey(name)) {
            candidates.put(name, 0);  // Initialize votes to 0
        }
    }

    // Cast a vote for a candidate
    public void castVote(String name) {
        // Check if candidate exists before voting
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);  // Increment vote count
        }
    }

    // Override toString to print candidates and their votes
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
        }
        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        vm.addCandidate("Alsobrooks");
        vm.castVote("Alsobrooks");
        vm.addCandidate("Hogan");
        System.out.println(vm.toString());
    }
}
