import java.util.Random;

/**
 * This hold the voting methods which create new ballots and mark candidates
 */

public class Voter implements VoterInterface {

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
        System.out.println("I'm a RandomVoter and I voted for: " + voteChoice);
        votie.cast(ballie);
    }

    /**
     * Randomly votes for a candidate using the default voting method (vote)
     * @param votie - an instance of the voting machine class
     */

    @Override
    public void RandomVoter(VotingMachine votie) {
        // RandomVoter - this kind of voter just uses the default implementation and votes randomly as before
        vote(votie);
    }

    /**
     * Votes for the users preferred candidate
     * @param votie - an instance of the voting machine class
     * @param preferredCandidate - the user specified preferred candidate
     */

    @Override
    public void LoyalVoter(VotingMachine votie, int preferredCandidate) {
        // LoyalVoter - this kind of voter always votes for the candidate with a specific integer index (this is specified via the constructor)
        Ballot ballie = votie.getBallot();
        ballie.mark(preferredCandidate);
        System.out.println("I'm a LoyalVoter and I voted for: " + preferredCandidate);
        votie.cast(ballie);
    }

    /**
     * Randomly votes for any candidate with an odd index
     * @param votie - an instance of the voting machine class
     */

    @Override
    public void OddVoter(VotingMachine votie) {
        // OddVoter - this kind of voter casts their vote randomly among the odd-indexed candidates only
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 1) {
                ballie.mark(voteChoice);
                System.out.println("I'm an OddVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
    }

    /**
     * Randomly votes for any candidate with an even index
     * @param votie - an instance of the voting machine class
     */

    @Override
    public void EvenVoter(VotingMachine votie) {
        // EvenVoter - this kind of voter casts their vote randomly among the even-indexed candidates only
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 0) {
                ballie.mark(voteChoice);
                System.out.println("I'm an EvenVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
    }

    /**
     * Randomly votes for any two candidates
     * @param votie - an instance of the voting machine class
     * @return - returns if the vote was cast (True) or not (False)
     */

    @Override
    public boolean DoubleVoter(VotingMachine votie) {
        // DoubleVoter - this kind of voter casts their vote for two randomly chosen candidates
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice1 = randie.nextInt(numberCandidates);
        int voteChoice2 = randie.nextInt(numberCandidates);
        while (true) {
            if (voteChoice1 != voteChoice2) {
                ballie.mark(voteChoice1);
                ballie.mark(voteChoice2);
                System.out.println("I'm a DoubleVoter and I voted for: " + voteChoice1 + " and " + voteChoice2);
                return votie.cast(ballie);
            } else {
                voteChoice2 = randie.nextInt(numberCandidates);
            }
        }

    }

    /**
     * Votes for the candidate at index 0
     * @param votie - an instance of the voting machine class
     */

    @Override
    public void FirstVoter(VotingMachine votie) {
        // FirstVoter - this kind of voter casts their vote for the candidate at index slot 0
        Ballot ballie = votie.getBallot();
        ballie.mark(0);
        System.out.println("I'm a FirstVoter and I voted for: " + 0);
        votie.cast(ballie);

    }
}
