import java.util.Scanner;

public class VotingSimulation extends Voter implements VoterInterface{

    /**
     * Outlines the users choices and begins the simulation loop
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of times to run the simulation: ");
        int numDiscardedVotes = 0;
        int userNumberVoters = 0;
        int numberSimulations = input.nextInt();
        for (int x = 0; x < numberSimulations; x++) {
            System.out.print("Input the number of candidates: ");
            int numberCandidates = input.nextInt();
            System.out.print("Input the number of random voters: ");
            int numRandomVoters = input.nextInt();
            userNumberVoters += numRandomVoters;
            System.out.print("Input the number of loyal voters: ");
            int numLoyalVoters = input.nextInt();
            userNumberVoters += userNumberVoters;
            numLoyalVoters += numRandomVoters;
            System.out.print("Input who the index of the candidate which the loyal voters will vote for: ");
            int loyalCandidate = input.nextInt();
            System.out.print("Input the number of odd voters: ");
            int numOddVoters = input.nextInt();
            userNumberVoters += numOddVoters;
            numOddVoters += numLoyalVoters;
            System.out.print("Input the number of even voters: ");
            int numEvenVoters = input.nextInt();
            userNumberVoters += numEvenVoters;
            numEvenVoters += numOddVoters;
            System.out.print("Input the number of double voters: ");
            int numDoubleVoters = input.nextInt();
            userNumberVoters += numDoubleVoters;
            numDoubleVoters += numEvenVoters;
            System.out.print("Input the number of first candidate voters: ");
            int numFirstVoters = input.nextInt();
            userNumberVoters += numFirstVoters;
            numFirstVoters += numDoubleVoters;
            System.out.println("You have selected " + userNumberVoters + " voters");
            VotingMachine votie = new VotingMachine();
            votie.configure(numberCandidates);
            Voter voter = new Voter();
            for (int i = 0; i < userNumberVoters; i++) {
                if (i < numRandomVoters) {
                    voter.RandomVoter(votie);
                    if (!voter.RandomVoter(votie)) {
                        numDiscardedVotes++;
                    }
                } else if (i < numLoyalVoters) {
                    voter.LoyalVoter(votie, loyalCandidate);
                    if (!voter.LoyalVoter(votie, loyalCandidate)) {
                        numDiscardedVotes++;
                    }
                } else if (i < numOddVoters) {
                    voter.OddVoter(votie);
                    if (!voter.OddVoter(votie)) {
                        numDiscardedVotes++;
                    }
                } else if (i < numEvenVoters) {
                    voter.EvenVoter(votie);
                    if (!voter.EvenVoter(votie)) {
                        numDiscardedVotes++;
                    }
                } else if (i < numDoubleVoters) {
                    boolean result = voter.DoubleVoter(votie);
                    if (result) {
                        System.out.println("The DoubleVote was cast. ");
                    } else {
                        System.out.println("The DoubleVote was not cast. ");
                        numDiscardedVotes++;
                    }
                } else if (i < numFirstVoters) {
                    voter.FirstVoter(votie);
                    if (!voter.FirstVoter(votie)) {
                        numDiscardedVotes++;
                    }
                }
            }

            System.out.println("-------------------");
            System.out.println("The winner is: " + votie.determineWinner("first"));
            System.out.println("The runner up is: " + votie.determineWinner("second"));
            System.out.println("The number of discarded votes is: " + numDiscardedVotes);
            if (votie.determineWinner("first") == votie.determineWinner("second")) {
                System.out.println("Beginning Run-off round: ");
                votie.configure(2);
                for (int i = 0; i < userNumberVoters; i++) {
                    voter.vote(votie);
                }
                System.out.println("-------------------");
                System.out.println("The grand winner is: " + votie.determineWinner("first"));
            }
        }
    }
}
