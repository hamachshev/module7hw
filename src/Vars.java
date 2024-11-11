public class Vars {
    volatile public boolean  t1WantsToEnter; // volatile to avoid chache problems of thread chaching
    volatile public boolean t2WantsToEnter;
    volatile public int favoredThread = 1;

    public Vars(boolean t1WantsToEnter, boolean t2WantsToEnter) {
        this.t1WantsToEnter = t1WantsToEnter;
        this.t2WantsToEnter = t2WantsToEnter;
    }
}
