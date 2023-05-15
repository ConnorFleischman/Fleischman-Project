public interface VoterInterface {
    /**
     * Randomly votes for a candidate using the default voting method (vote)
     * @param votie - an instance of the voting machine class
     */
    void RandomVoter(VotingMachine votie);
    /**
     * Votes for the users preferred candidate
     * @param votie - an instance of the voting machine class
     * @param preferredCandidate - the user specified preferred candidate
     */
    void LoyalVoter(VotingMachine votie, int preferredCandidate);
    /**
     * Randomly votes for any candidate with an odd index
     * @param votie - an instance of the voting machine class
     */
    void OddVoter(VotingMachine votie);
    /**
     * Randomly votes for any candidate with an even index
     * @param votie - an instance of the voting machine class
     */
    void EvenVoter(VotingMachine votie);
    /**
     * Randomly votes for any two candidates
     * @param votie - an instance of the voting machine class
     * @return - returns if the vote was cast (True) or not (False)
     */
    boolean DoubleVoter(VotingMachine votie);
    /**
     * Votes for the candidate at index 0
     * @param votie - an instance of the voting machine class
     */
    void FirstVoter(VotingMachine votie);
}
