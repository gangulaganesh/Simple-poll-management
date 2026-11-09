
import java.util.*;

public class Poll {
    private int pollId;
    private String question;
    private ArrayList<PollOption> options;
    private HashSet<String> voters;
    private boolean closed;

    public Poll(int pollId, String question) {
        this.pollId = pollId;
        this.question = question;
        options = new ArrayList<>();
        voters = new HashSet<>();
        closed = false;
    }

    public int getPollId() {
        return pollId;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isClosed() {
        return closed;
    }

    public void addOption(String option) {
        options.add(new PollOption(option));
    }

    public boolean vote(String studentId, int choice) {

        if (closed) {
            System.out.println("Poll is closed!");
            return false;
        }

        if (voters.contains(studentId)) {
            System.out.println("You have already voted!");
            return false;
        }

        if (choice < 1 || choice > options.size()) {
            System.out.println("Invalid option!");
            return false;
        }

        options.get(choice - 1).addVote();
        voters.add(studentId);

        System.out.println("Vote submitted successfully!");
        return true;
    }

    public void closePoll() {
        closed = true;
        System.out.println("Poll closed successfully!");
    }

    public void showResults() {

        int totalVotes = 0;

        for (PollOption option : options) {
            totalVotes += option.getVotes();
        }

        System.out.println("\n----- POLL RESULTS -----");
        System.out.println(question);

        for (PollOption option : options) {

            double percentage = 0;

            if (totalVotes > 0) {
                percentage = option.getVotes() * 100.0 / totalVotes;
            }

            System.out.printf("%s : %d votes (%.2f%%)%n",
                    option.getOptionName(),
                    option.getVotes(),
                    percentage);
        }

        System.out.println("Total Votes: " + totalVotes);
        System.out.println("Status: " + (closed ? "Closed" : "Open"));
    }

    public void displayPoll() {
        System.out.println("\nPoll ID: " + pollId);
        System.out.println("Question: " + question);

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " +
                    options.get(i).getOptionName());
        }

        System.out.println("Status: " + (closed ? "Closed" : "Open"));
    }

    public int getOptionCount() {
        return options.size();
    }
}
