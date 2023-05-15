import java.util.Random;
/**
 * This hold the voting methods which create new ballots and mark candidates
 */
public class Voter implements VoterInterface {

    /**
     * This allows the program to mark the ballot as True at a random position
     * @param votie - an instance of the voting machine class
     */

    public boolean vote(VotingMachine votie) {
        boolean markCandidate;
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice = randie.nextInt(numberCandidates);
        if (randie.nextFloat(101) > 10) {
            markCandidate = ballie.markCandidates(voteChoice, 2);

        } else {
            markCandidate = ballie.markCandidates(voteChoice, randie.nextInt(2));
        }
        System.out.println("I'm a RandomVoter and I voted for: " + voteChoice);
        votie.cast(ballie);
        return markCandidate;
    }

    /**
     * Randomly votes for a candidate using the default voting method (vote)
     * @param votie - an instance of the voting machine class
     */

    @Override
    public boolean RandomVoter(VotingMachine votie) {
        return vote(votie);
    }

    /**
     * Votes for the users preferred candidate
     * @param votie - an instance of the voting machine class
     * @param preferredCandidate - the user specified preferred candidate
     */

    @Override
    public boolean LoyalVoter(VotingMachine votie, int preferredCandidate) {
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        boolean markCandidate = ballie.markCandidates(preferredCandidate, randie.nextInt(3));
        System.out.println("I'm a LoyalVoter and I voted for: " + preferredCandidate);
        votie.cast(ballie);
        return markCandidate;
    }

    /**
     * Randomly votes for any candidate with an odd index
     * @param votie - an instance of the voting machine class
     */

    @Override
    public boolean OddVoter(VotingMachine votie) {
        boolean markCandidate;
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 1) {
                markCandidate = ballie.markCandidates(voteChoice, randie.nextInt(3));
                System.out.println("I'm an OddVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
        return markCandidate;
    }

    /**
     * Randomly votes for any candidate with an even index
     * @param votie - an instance of the voting machine class
     */

    @Override
    public boolean EvenVoter(VotingMachine votie) {
        boolean markCandidate;
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 0) {
                markCandidate = ballie.markCandidates(voteChoice, randie.nextInt(3));
                System.out.println("I'm an EvenVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
        return markCandidate;
    }

    /**
     * Randomly votes for any two candidates
     * @param votie - an instance of the voting machine class
     * @return - returns if the vote was cast (True) or not (False)
     */

    @Override
    public boolean DoubleVoter(VotingMachine votie) {
        boolean markCandidate1;
        boolean markCandidate2;
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        while (true) {
            int voteChoice1 = randie.nextInt(numberCandidates);
            int voteChoice2 = randie.nextInt(numberCandidates);
            if (voteChoice1 != voteChoice2) {
                int voteWeight1 = randie.nextInt(3);
                int voteWeight2 = randie.nextInt(3);
                while (true) {
                    if (voteWeight1 != voteWeight2) {
                        markCandidate1 = ballie.markCandidates(voteChoice1, voteWeight1);
                        markCandidate2 = ballie.markCandidates(voteChoice2, voteWeight2);
                        break;
                    }
                }
                System.out.println("I'm a DoubleVoter and I voted for: " + voteChoice1 + " and " + voteChoice2);
                votie.cast(ballie);
                return (markCandidate1 && markCandidate2 && votie.cast(ballie));
            }
        }
    }

    /**
     * Votes for the candidate at index 0
     * @param votie - an instance of the voting machine class
     */

    @Override
    public boolean FirstVoter(VotingMachine votie) {
        boolean markCandidate;
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        markCandidate = ballie.markCandidates(0, randie.nextInt(3));
        System.out.println("I'm a FirstVoter and I voted for: " + 0);
        votie.cast(ballie);

        return markCandidate;
    }
}
