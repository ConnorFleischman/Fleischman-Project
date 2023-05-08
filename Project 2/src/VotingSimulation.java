import java.util.Scanner;

public class VotingSimulation {

    /**
     * Outlines the users choices and begins the simulation loop
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of times to run the simulation: ");
        int numberSimulations = input.nextInt();
        for (int x = 0; x < numberSimulations; x++) {
            System.out.print("Input the number of candidates: ");
            int numberCandidates = input.nextInt();
            System.out.print("Input the number of voters: ");
            int userNumberVoters = input.nextInt();
            VotingMachine votie = new VotingMachine();
            votie.configure(numberCandidates);
            Voter voter = new Voter();
            for (int i = 0; i < userNumberVoters; i++) {
                voter.vote(votie);
            }
            System.out.println("-------------------");
            System.out.println("The winner is: " + votie.determineWinner("first"));
            System.out.println("The runner up is: " + votie.determineWinner("second"));
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
