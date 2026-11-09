
public class PollOption {
    private String optionName;
    private int votes;

    public PollOption(String optionName) {
        this.optionName = optionName;
        this.votes = 0;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }
}
