public class Ballot {
    private final boolean[] candidates;

    public Ballot(int numberCandidates){
        candidates = new boolean[numberCandidates];
    }
    public void mark(int index) {
        candidates[index] = true;
    }
    public boolean getMark(int index) {
        return candidates[index];
    }
    public int countCandidates() {
        return candidates.length;
    }


}
