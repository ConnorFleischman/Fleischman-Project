public interface VoterInterface {
    void RandomVoter(VotingMachine votie);

    void LoyalVoter(VotingMachine votie, int preferedCandidate);

    void OddVoter(VotingMachine votie);

    void EvenVoter(VotingMachine votie);

    void DoubleVoter(VotingMachine votie);

    void FirstVoter(VotingMachine votie);
}
