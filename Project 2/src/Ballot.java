/**
 * This is the ballot class which creates a boolean list with length of 'numberCandidates'
 */
public class Ballot {

    private boolean[] candidates;

    /**
     * This sets the length of the list
     * @param numberCandidates - the number of candidates which is specified by the user
     */

    public Ballot(int numberCandidates){
        candidates = new boolean[numberCandidates];
    }

    /**
     * This sets the boolean value of the index position in the list to true
     * @param index - the index is the position of a candidate in the list
     */
    public void mark(int index) {
        candidates[index] = true;
    }

    /**
     * This returns the boolean value of the specified index
     * @param index - the index is the position of a candidate in the list
     * @return - this returns the T/F value of the index
     */
    public boolean getMark(int index) {
        return candidates[index];
    }

    /**
     * This returns the length of the candidates list
     * @return - this returns the length of the list as an int
     */
    public int countCandidates() {
        return candidates.length;
    }


}
