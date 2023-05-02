
public class VotingMachine {
    private Ballot configuredBallot;
    private int[] voteCounts;

    public void configure(int numberCandidates) {
        Ballot emptyBallot = new Ballot(numberCandidates);
        voteCounts = new int[numberCandidates];
    }

    public boolean cast(Ballot ballot) {
        int voteChoice;
        boolean votePresent = false;
        for (int i = 0; i < ballot.countCandidates(); i++) {
            if (ballot.getMark(i) && !votePresent) {
                voteChoice = i;
                votePresent = true;
                configure(voteChoice);
            } else if (ballot.getMark(i) && votePresent) {
                return false;
            }
        }
        return votePresent;
    }
    public void reset() {
        configure(0);
    }
    public int determineWinner() {
        int mostVoted = 0;
        int mostVotedIndex = 0;
        for (int x = 0; x < voteCounts.length; x++) {
            if (voteCounts[x] > mostVoted) {
                mostVoted = voteCounts[x];
                mostVotedIndex = x;
            }
        }
        return mostVotedIndex;
    }
    public Ballot getBallot() {
        return configuredBallot;
    }
}
