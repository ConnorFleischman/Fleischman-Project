import java.util.Random;
public class Voter {
    public void vote(VotingMachine votie) {
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice = randie.nextInt(0, numberCandidates);
        ballie.mark(voteChoice);
        votie.cast(ballie);
    }
}
