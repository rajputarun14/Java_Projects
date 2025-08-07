public class Main {
    public static void main(String args[]) throws InterruptedException
    {
        TokenBucket bucket = new TokenBucket(5,1);
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(100); // Simulate 300ms between requests
            bucket.allowRequest();
        }
    }
}
