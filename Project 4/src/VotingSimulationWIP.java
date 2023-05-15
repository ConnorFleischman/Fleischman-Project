import java.util.Scanner;

public class VotingSimulationWIP extends Voter implements VoterInterface {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of times to run the simulation: ");
        int numberSimulations = input.nextInt();
        for (int x = 0; x < numberSimulations; x++) {
            userInput();
        }
    }

    private static void userInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of candidates: ");
        int numberCandidates = input.nextInt();
    }
}
