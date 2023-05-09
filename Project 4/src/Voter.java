import java.util.Random;

public class Voter implements VoterInterface {
    public void vote(VotingMachine votie) {
        Ballot ballie = votie.getBallot();
        int numberCandidates = ballie.countCandidates();
        Random randie = new Random();
        int voteChoice = randie.nextInt(numberCandidates);
        int probabilityWeight = randie.nextInt(101);
        if (probabilityWeight > 10) {
            ballie.markCandidates(voteChoice, 2);
        } else {
            ballie.markCandidates(voteChoice, randie.nextInt(2));
        }
        System.out.println("I'm a RandomVoter and I voted for: " + voteChoice);
        votie.cast(ballie);
    }
    @Override
    public void RandomVoter(VotingMachine votie) {
        // RandomVoter - this kind of voter just uses the default implementation and votes randomly as before
        vote(votie);
    }
    @Override
    public void LoyalVoter(VotingMachine votie, int preferredCandidate) {
        // LoyalVoter - this kind of voter always votes for the candidate with a specific integer index (this is specified via the constructor)
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        ballie.markCandidates(preferredCandidate, randie.nextInt(3));
        System.out.println("I'm a LoyalVoter and I voted for: " + preferredCandidate);
        votie.cast(ballie);
    }
    @Override
    public void OddVoter(VotingMachine votie) {
        // OddVoter - this kind of voter casts their vote randomly among the odd-indexed candidates only
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 1) {
                ballie.markCandidates(voteChoice, randie.nextInt(3));
                System.out.println("I'm an OddVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
    }
    @Override
    public void EvenVoter(VotingMachine votie) {
        // EvenVoter - this kind of voter casts their vote randomly among the even-indexed candidates only
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        int numberCandidates = ballie.countCandidates();
        while (true) {
            int voteChoice = randie.nextInt(numberCandidates);
            if (voteChoice % 2 == 0) {
                ballie.markCandidates(voteChoice, randie.nextInt(3));
                System.out.println("I'm an EvenVoter and I voted for: " + voteChoice);
                votie.cast(ballie);
                break;
            }
        }
    }
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
                int voteWeight1 = randie.nextInt(3);
                int voteWeight2 = randie.nextInt(3);
            while (true) {
                if (voteWeight1 != voteWeight2) {
                    ballie.markCandidates(voteChoice1, voteWeight1);
                    ballie.markCandidates(voteChoice2, voteWeight2);
                    break;
                } else {
                    voteWeight2 = randie.nextInt(3);
                }
            }
                System.out.println("I'm a DoubleVoter and I voted for: " + voteChoice1 + " and " + voteChoice2);
                return votie.cast(ballie);
            } else {
                voteChoice2 = randie.nextInt(numberCandidates);
            }
        }

    }
    @Override
    public void FirstVoter(VotingMachine votie) {
        // FirstVoter - this kind of voter casts their vote for the candidate at index slot 0
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        ballie.markCandidates(0, randie.nextInt(3));
        System.out.println("I'm a FirstVoter and I voted for: " + 0);
        votie.cast(ballie);

    }
}
