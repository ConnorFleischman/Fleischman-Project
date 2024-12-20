import java.util.Scanner;

/**
 * Runs the program
 */

public class VotingSimulation extends Voter implements VoterInterface{

    /**
     * Contains all the inputs and outputs for the program as well as the loops for the votes and for the simulations
     * @param args - unused
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of times to run the simulation: ");
        int numDiscardedVotes = 0;
        int numberSimulations = input.nextInt();
        for (int x = 0; x < numberSimulations; x++) {
            System.out.print("Input the number of candidates: ");
            int numberCandidates = input.nextInt();
            System.out.print("Input the number of random voters: ");
            int numRandomVoters = input.nextInt();
            System.out.print("Input the number of loyal voters: ");
            int numLoyalVoters = input.nextInt() + numRandomVoters;
            System.out.print("Input who the index of the candidate which the loyal voters will vote for: ");
            int loyalCandidate = input.nextInt();
            System.out.print("Input the number of odd voters: ");
            int numOddVoters = input.nextInt() + numLoyalVoters;
            System.out.print("Input the number of even voters: ");
            int numEvenVoters = input.nextInt() + numOddVoters;
            System.out.print("Input the number of double voters: ");
            int numDoubleVoters = input.nextInt() + numEvenVoters;
            System.out.print("Input the number of first candidate voters: ");
            int numFirstVoters = input.nextInt() + numDoubleVoters;
            int userNumberVoters = numRandomVoters + numLoyalVoters + numOddVoters + numEvenVoters + numDoubleVoters + numFirstVoters;
            System.out.println("You have selected " + userNumberVoters + " voters");
            VotingMachine votie = new VotingMachine();
            votie.configure(numberCandidates);
            Voter voter = new Voter();
            for (int i = 0; i < userNumberVoters; i++) {
                if (i < numRandomVoters) {
                    voter.RandomVoter(votie);
                } else if (i < numLoyalVoters) {
                    voter.LoyalVoter(votie, loyalCandidate);
                } else if (i < numOddVoters) {
                    voter.OddVoter(votie);
                } else if (i < numEvenVoters) {
                    voter.EvenVoter(votie);
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
