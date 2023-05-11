import java.util.Random;

public class Voter implements VoterInterface {
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
    @Override
    public boolean RandomVoter(VotingMachine votie) {
        // RandomVoter - this kind of voter just uses the default implementation and votes randomly as before
        return vote(votie);
    }
    @Override
    public boolean LoyalVoter(VotingMachine votie, int preferredCandidate) {
        // LoyalVoter - this kind of voter always votes for the candidate with a specific integer index (this is specified via the constructor)
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        boolean markCandidate = ballie.markCandidates(preferredCandidate, randie.nextInt(3));
        System.out.println("I'm a LoyalVoter and I voted for: " + preferredCandidate);
        votie.cast(ballie);
        return markCandidate;
    }
    @Override
    public boolean OddVoter(VotingMachine votie) {
        // OddVoter - this kind of voter casts their vote randomly among the odd-indexed candidates only
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
    @Override
    public boolean EvenVoter(VotingMachine votie) {
        // EvenVoter - this kind of voter casts their vote randomly among the even-indexed candidates only
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
    @Override
    public boolean DoubleVoter(VotingMachine votie) {
        // DoubleVoter - this kind of voter casts their vote for two randomly chosen candidates
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
    @Override
    public boolean FirstVoter(VotingMachine votie) {
        // FirstVoter - this kind of voter casts their vote for the candidate at index slot 0
        boolean markCandidate;
        Ballot ballie = votie.getBallot();
        Random randie = new Random();
        markCandidate = ballie.markCandidates(0, randie.nextInt(3));
        System.out.println("I'm a FirstVoter and I voted for: " + 0);
        votie.cast(ballie);

        return markCandidate;
    }
}
