import java.util.Objects;

public class VotingMachine {
    private Ballot configuredBallot;
    private int[] voteCounts;

    public void configure(int numberCandidates) {
        configuredBallot = new Ballot(numberCandidates);
        voteCounts = new int[numberCandidates];
    }

    public boolean cast(Ballot ballot) {
        int votedCandidate = 0;
        boolean votePresent = false;
        for (int i = 0; i < ballot.countCandidates(); i++) {
            if (ballot.getMark(i) && !votePresent) {
                votePresent = true;
                voteCounts[i]++;
                votedCandidate = i;
            } else if (ballot.getMark(i) && votePresent) {
                voteCounts[votedCandidate]--;
                return false;
            }
        }
        return votePresent;
    }
    public void reset() {
        configure(0);
    }
    public int determineWinner(String place) {
        int winningCandidate = 0;
        int runnerUpCandidate = 0;
        int returnedCandidate = 0;
        for (int i = 0; i < voteCounts.length; i++) {
            if (i != winningCandidate && voteCounts[i] == voteCounts[winningCandidate]) {
                runnerUpCandidate = i;
            } else if (voteCounts[i] > voteCounts[winningCandidate]) {
                winningCandidate = i;
            } else if (voteCounts[i] > voteCounts[runnerUpCandidate]) {
                runnerUpCandidate = i;
            }
        }

        if (Objects.equals(place, "first")) {
            returnedCandidate = winningCandidate;
        } else if (Objects.equals(place, "second")) {
            returnedCandidate = runnerUpCandidate;
        }
        return returnedCandidate;
    }
    public Ballot getBallot() {
        return configuredBallot;
    }
}

