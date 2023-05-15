import java.util.Random;

/**
 * This hold the vote method which creates a new ballot and marks it on a random candidate
 */
public class Voter {
    /**
     * This allows the program to mark the ballot as True at a random position
     * @param votie - an instance of the voting machine class
     */
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
