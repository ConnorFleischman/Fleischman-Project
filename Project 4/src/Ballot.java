public class Ballot {
    /**
     * Creates a list of marks
     */
    private Mark[] candidates;

    /**
     * Marks consists of the 3 types below
     */
    enum Mark {NONE, FAINT, CLEAR}

    /**
     * Creates a new ballot of marks with length of numberCandidates
     * @param numberCandidates - the user specified number of candidates
     */

    public Ballot(int numberCandidates){
        candidates = new Mark[numberCandidates];
    }

    /**
     * Marks the candidate with a weighted mark
     * @param index - the index of the candidate being marked
     * @param markType - the weight of the mark
     * @return - returns if the candidate was marked or not
     */

    public boolean markCandidates(int index, int markType) {
        boolean markCast = false;
            if (markType == 0) {
                candidates[index] = Mark.NONE;
                System.out.println("I marked NONE, my vote was not cast");
            } if (markType == 1) {
                candidates[index] = Mark.FAINT;
                System.out.println("I marked FAINT, my vote was not cast");
        } if (markType == 2) {
                candidates[index] = Mark.CLEAR;
                System.out.println("I marked CLEAR, my vote was cast");
                markCast = true;

            }
        return markCast;
    }

    /**
     * Returns true if the mark was made and is castable
     * @param index - the index of the candidate being marked
     * @return - returns true if mark is castable (clear) or false if not (ie. faint, none)
     */

    public boolean getMark(int index) {
        return candidates[index] == Mark.CLEAR;
    }

    /**
     * Counts the number of candidates
     * @return - returns the number of candidates as an int
     */

    public int countCandidates() {
        return candidates.length;
    }


}
