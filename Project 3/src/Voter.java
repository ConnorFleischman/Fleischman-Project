import java.util.Random;

public class Voter implements VoterInterface {

    @Override
    public void RandomVoter(VotingMachine votie) {
        // RandomVoter - this kind of voter just uses the default implementation and votes randomly as before
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice = randie.nextInt(numberCandidates);
        ballie.mark(voteChoice);
        System.out.println("I voted for: " + voteChoice);
        votie.cast(ballie);
    }
    @Override
    public void LoyalVoter() {
        // LoyalVoter - this kind of voter always votes for the candidate with a specific integer index (this is specified via the constructor)
    }
    @Override
    public void OddVoter() {
        // OddVoter - this kind of voter casts their vote randomly among the odd-indexed candidates only
    }
    @Override
    public void EvenVoter() {
        // EvenVoter - this kind of voter casts their vote randomly among the even-indexed candidates only
    }
    @Override
    public void DoubleVoter() {
        // DoubleVoter - this kind of voter casts their vote for two randomly chosen candidates
    }
    @Override
    public void FirstVoter() {
        // FirstVoter - this kind of voter casts their vote for the candidate at index slot 0
    }
}
