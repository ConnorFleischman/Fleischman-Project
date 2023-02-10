import java.util.Scanner;
import java.util.Random;
public class TwoRoundRunOffVoting {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of candidates: ");
        int numberCandidates = input.nextInt();
        System.out.print("Input the number of voters: ");
        int userNumberVoters = input.nextInt();
        System.out.print("Input the number of times to run the simulation: ");
        int numberSimulations = input.nextInt();
        while (numberSimulations != 0) {
            int numberVotersRound1 = userNumberVoters ;
            int winnerCandidate = 0;
            int winnerVotes = 0;
            int runnerUpCandidate = 0;
            int runnerUpVotes = 0;
            for (int i = 1; i < numberCandidates + 1; i++) {
                int votesGivenRound1;
                if (i == numberCandidates) {
                    votesGivenRound1 = numberVotersRound1;
                } else {
                    votesGivenRound1 = random.nextInt(0, numberVotersRound1);
                }
                if (votesGivenRound1 > winnerVotes) {
                    winnerVotes = votesGivenRound1;
                    winnerCandidate = i;
                } else if (votesGivenRound1 > runnerUpVotes) {
                    runnerUpVotes = votesGivenRound1;
                    runnerUpCandidate = i;
                }
                numberVotersRound1 = numberVotersRound1 - votesGivenRound1;
            }
            int round2Candidate1Votes = random.nextInt(0, userNumberVoters);
            int round2Candidate2Votes = userNumberVoters - round2Candidate1Votes;

            System.out.println();
            System.out.println("Simulation " + numberSimulations + ": ");
            System.out.println();
            System.out.println("Round 1: ");
            System.out.println(winnerCandidate + " has " + winnerVotes + " votes");
            System.out.println(runnerUpCandidate + " has " + runnerUpVotes + " votes");
            System.out.println();
            System.out.println("Round 2: ");
            System.out.println(winnerCandidate + " has " + round2Candidate1Votes + " votes");
            System.out.println(runnerUpCandidate + " has " + round2Candidate2Votes + " votes");
            System.out.println();

            numberSimulations--;
        }

    }
}