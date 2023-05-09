import java.util.Random;

public class Ballot {
    private Mark[] candidates;
    enum Mark {NONE, FAINT, CLEAR}

    public Ballot(int numberCandidates){
        candidates = new Mark[numberCandidates];
    }
    public void markCandidates(int index, int markType) {
            if (markType == 0) {
                candidates[index] = Mark.NONE;
                System.out.println("I marked NONE, my vote was not cast");
            } if (markType == 1) {
                candidates[index] = Mark.FAINT;
                System.out.println("I marked FAINT, my vote was not cast");
            } if (markType == 2) {
                candidates[index] = Mark.CLEAR;
                System.out.println("I marked CLEAR, my vote was cast");
            }
        }
    public boolean getMark(int index) {
        return candidates[index] == Mark.CLEAR;
    }
    public int countCandidates() {
        return candidates.length;
    }


}
