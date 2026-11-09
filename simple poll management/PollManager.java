
import java.util.*;

public class PollManager {

    private ArrayList<Poll> polls = new ArrayList<>();
    private int nextId = 1;

    public void createPoll(String question, ArrayList<String> options) {

        Poll poll = new Poll(nextId++, question);

        for (String option : options) {
            poll.addOption(option);
        }

        polls.add(poll);

        System.out.println("Poll created successfully!");
    }

    public void displayPolls() {

        if (polls.isEmpty()) {
            System.out.println("No polls available.");
            return;
        }

        for (Poll poll : polls) {
            poll.displayPoll();
        }
    }

    public Poll findPoll(int id) {

        for (Poll poll : polls) {
            if (poll.getPollId() == id) {
                return poll;
            }
        }

        return null;
    }

    public void closePoll(int id) {

        Poll poll = findPoll(id);

        if (poll != null) {
            poll.closePoll();
        } else {
            System.out.println("Poll not found!");
        }
    }

    public void showResults(int id) {

        Poll poll = findPoll(id);

        if (poll != null) {
            poll.showResults();
        } else {
            System.out.println("Poll not found!");
        }
    }

    public boolean hasPolls() {
        return !polls.isEmpty();
    }
}
