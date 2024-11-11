public class MutualExclusionWorksThreadOne extends Thread {
    public boolean done = false;
    public Vars vars;

    public MutualExclusionWorksThreadOne(Vars vars) {
        this.vars = vars;
    }

    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!done) {
            vars.t1WantsToEnter = true;
            while (vars.favoredThread == 2){
                while(vars.t2WantsToEnter);

                vars.favoredThread = 1;
            }
            System.out.println("hello from thread 1 critical section");
            System.out.println("left critical section of t1");
            vars.t1WantsToEnter = false;
            System.out.println("non critical t1");
            done = true;
        }
    }
}
