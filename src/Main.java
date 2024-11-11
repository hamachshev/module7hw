public class Main {
    public static void mutualExclusionProblem(){
        Vars vars = new Vars(false, false);
        Thread T1 = new MutualExclusionProbThreadOne(vars);
        Thread T2 = new MutualExclusionProbThreadTwo(vars);

        T2.start();
        T1.start();
    }

    public static void mutualExclusionWorks(){
        Vars vars = new Vars(false, false);
        Thread T1 = new MutualExclusionWorksThreadOne(vars);
        Thread T2 = new MutualExclusionWorksThreadTwo(vars);

        T2.start();
        T1.start();
    }
    public static void main(String[] args) {
        mutualExclusionProblem();
    }

}