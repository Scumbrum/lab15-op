public class Timecounter {
    public static long count(Executor executor){
        long curr =System.currentTimeMillis();
        executor.execute();
        return System.currentTimeMillis()-curr;
    }
}
