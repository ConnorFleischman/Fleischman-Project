import java.util.Objects;

/**
 * This is the voting machine which allows for numerous actions to set up and run the voting
 */

public class VotingMachine {

    private Ballot configuredBallot;
    private int[] voteCounts;

    /**
     * This configures the ballot and the vote counts to have a length of numberCandidates
     * @param numberCandidates - the number of candidates which is specified by the user
     */

    public void configure(int numberCandidates) {
        configuredBallot = new Ballot(numberCandidates);
        voteCounts = new int[numberCandidates];
    }

    /**
     * This casts an already marked ballot by incrementing the index of the candidate in voteCounts by 1
     * @param ballot - the instance of ballot being used in a specific vote
     * @return - returns if the vote was cast (True) or not (False)
     */

    public boolean cast(Ballot ballot) {
        int votesPresent = 0;
        boolean voteCast = false;
        for (int i = 0; i < ballot.countCandidates(); i++) {
            if (ballot.getMark(i)) {
                votesPresent++;
            }
        }
        for (int x = 0; x < ballot.countCandidates(); x++) {
            if (votesPresent == 1) {
                voteCounts[x]++;
                voteCast = true;
            } else {
                break;
            }
        }
        return voteCast;
    }

    /**
     * Resets the number of candidates to 0
     */

    public void reset() {
        configure(0);
    }

    /**
     *
     * @param place - input "first" or "second" for the first and second place respectively
     * @return - returns the specified placeholder
     */

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

    /**
     * Gets an empty ballot
     * @return - returns the empty ballot
     */

    public Ballot getBallot() {
        return configuredBallot;
    }
}

