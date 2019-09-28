package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(()->{
           Thread.sleep(1000);
           return "FutureTask";
        });
        new Thread(futureTask).start();
        Thread.sleep(2000);
        System.out.println(futureTask.get());
    }
}
