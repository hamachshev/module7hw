public class MutualExclusionProbThreadOne extends Thread {
    public boolean done = false;
    public Vars vars;

    public MutualExclusionProbThreadOne(Vars vars){
        this.vars = vars;
    }
    @Override
    public void run() {
        try {
            sleep(5000); // give thread two head start to get to pause point (context switch on 16)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(!done){
            vars.t1WantsToEnter = true;
            while (vars.favoredThread == 2) {
                while (vars.t2WantsToEnter);
                vars.favoredThread = 1;
            }

            System.out.println("Hi from critical section of thread 1");
            try {
                sleep(5000); // stop in critical section so t2 can come here too
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("left critical section of t1");
            vars.t1WantsToEnter = false;
            System.out.println("non critical t1");
            done = true;
        }
    }
}
