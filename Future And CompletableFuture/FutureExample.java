import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String [] args)
    {
        System.out.println("Main thread begin");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        String a = "arun";
        String b = "Kumar"; 
        Future<String> future = executor.submit( () -> {

            System.out.println("future thread");
            Thread.sleep(2000);
            return a + " " + b;
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }

        try {
            String futureValue = future.get();
            System.out.println(future);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Main thread;");
    }
}
