import java.util.Random;
public class Voter {
    public void vote(VotingMachine votie) {
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice = randie.nextInt(numberCandidates);
        ballie.mark(voteChoice);
        System.out.println("I voted for: " + voteChoice);
        votie.cast(ballie);
    }
}
