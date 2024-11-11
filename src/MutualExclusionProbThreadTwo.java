public class MutualExclusionProbThreadTwo extends Thread {
    public boolean done = false;
    public Vars vars;

    public MutualExclusionProbThreadTwo(Vars vars) {
        this.vars = vars;
    }

    @Override
    public void run() {

        while (!done) {
            vars.t2WantsToEnter = true;
            while (vars.favoredThread == 1){
                while(vars.t1WantsToEnter);
                try {
                    sleep(6000); // context switch for longer to allow t1 thread to catch up
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                vars.favoredThread = 2;
            }
            System.out.println("hello from thread 2 critical section");
            System.out.println("left critical section of t2");
            vars.t2WantsToEnter = false;
            System.out.println("non critical t2");
            done = true;
        }
    }
}
