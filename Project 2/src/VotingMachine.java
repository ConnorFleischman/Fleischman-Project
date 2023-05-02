public class VotingMachine {
    private void configure(int numberCandidates) {
        // create and store empty ballot for number of candidates
        //      serves as a template for voter
        // assign voteCounts a new empty array that matches the num candates on ballot
    }


    public boolean cast(Ballot ballot) {
        int voteChoice;
        boolean votePresent = false;
        for (int i = 0; i < ballot.countCandidates(); i++) {
            if (ballot.getMark(i) && !votePresent) {
                voteChoice = i;
                votePresent = true;
                } else if (ballot.getMark(i) && votePresent) {
                return false;
            }
        }
        return votePresent;

    }
    public void reset() {
        // set all vote counts = 0
    }
    public int determineWinner() {
        // find index of max vote count
        // return this as vote winner
        return 0;
    }
    public Ballot getBallot() {
        return null;
    }
}
