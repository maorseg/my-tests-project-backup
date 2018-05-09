/*
public class Count {
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
        }
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        System.out.println(Float.toString(seconds) + " seconds.");
    }
}*/


import java.util.concurrent.TimeUnit;

public class Count {

    public static void main(String[] args) throws InterruptedException {

        //start
        long lStartTime = System.nanoTime();

        //task
        calculation();

        //end
        long lEndTime = System.nanoTime();

        //time elapsed
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output / 1000000);

    }

    private static void calculation() throws InterruptedException {

        //Sleep 2 seconds
        TimeUnit.SECONDS.sleep(2);

    }
}