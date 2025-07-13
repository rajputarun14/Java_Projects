import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample{
    public static void main (String [] args)
    {
        System.out.println("Main thread");

        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
                System.out.println("step 1");
                
                return "Arun";
        }).thenApply(result -> {
            System.out.println(result + " Kumar");
            result = result + "Kumar";
            return result;
        }).thenAccept((result) -> {
            System.out.println(result);
        });
    
    }
}