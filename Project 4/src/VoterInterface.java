public interface VoterInterface {
    boolean RandomVoter(VotingMachine votie);

    boolean LoyalVoter(VotingMachine votie, int preferedCandidate);

    boolean OddVoter(VotingMachine votie);

    boolean EvenVoter(VotingMachine votie);

    boolean DoubleVoter(VotingMachine votie);

    boolean FirstVoter(VotingMachine votie);
}
