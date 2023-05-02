import java.util.Scanner;

//VotingSimulation.java contains the VotingSimulation class (this holds your main method and your other static methods)
//        Your main method should contain the primary loop of the program and should instantiate classes and call their methods as needed.
//        You should be able to reuse some of your earlier static methods, such as the one that reads the user input.
//        Include Javadoc comments explaining the purpose of each class and method.
//        Tasks (or subtasks) that need to be done...
//        read user input into appropriate variables (this should already be done from Project 1 and should now have to change)
//        simulate the two-round vote procedure in a loop as many times as needed
//        after a first round vote, you'll need to determine whether a second round is needed
//        if so, then it works just like the first round except that only the top two candidates are involved (but use the same number of total voters)
//        to simulate a single vote, replace your previous logic with an implementation of the procedure described in the attached design diagram
//        report the results to the user in neat and easy to read form (this code should also not need to change much from the Project 1 version)
public class VotingSimulation1 {

    /**
     * Outlines the users choices and begins the simulation loop
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of candidates: ");
        int numberCandidates = input.nextInt();
        System.out.print("Input the number of voters: ");
        int userNumberVoters = input.nextInt();
        System.out.print("Input the number of times to run the simulation: ");
        int numberSimulations = input.nextInt();
        VotingMachine votie = new VotingMachine();
        votie.configure(numberCandidates);
        Voter voter = new Voter();
        Ballot ballot = new Ballot(numberCandidates);
        voter.vote(votie);
//        simulation(userNumberVoters, numberSimulations);

    }
}

//    /**
//     * Loops the two-round runoff voting for the number of simulations
//     * @param userNumberVoters - the user specified number of voters
//     * @param numberSimulations - the user specified number of simulations
//     */
//    public static void simulation(int userNumberVoters, int numberSimulations) {
//        int printNumberSimulations = 1;
//        while (numberSimulations != 0) {
//            System.out.println();
//            System.out.println("Simulation " + printNumberSimulations + ": ");
//            System.out.println();
//            printNumberSimulations++;
//            numberSimulations--;
//        }
//    }