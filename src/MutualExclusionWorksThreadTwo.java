public class MutualExclusionWorksThreadTwo extends Thread {
    public boolean done = false;
    public Vars vars;

    public MutualExclusionWorksThreadTwo(Vars vars) {
        this.vars = vars;
    }

    @Override
    public void run() {
        while (!done) {
            vars.t2WantsToEnter = true;
            while (vars.favoredThread == 1){
                while(vars.t1WantsToEnter);
                vars.favoredThread = 2;
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("hello from thread 2 critical section");
            System.out.println("left critical section of t2");
            vars.t2WantsToEnter = false;
            System.out.println("non critical t2");
            done = true;
        }
    }
}
