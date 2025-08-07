public class TokenBucket{
    int capacity;
    double currentTokens;
    double refillRatePerSecond;
    long lastRefillTime;

    public TokenBucket(int capacity, double refillRatePerSecond)
    {   
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        currentTokens = capacity;
        lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest()
    {
        refill();
        if(currentTokens > 0)
        {
            currentTokens --;
            System.out.println("Request allowed");
            return true;
        }
        System.out.println("Request Not allowed");
        return false;
    }
    public void refill()
    {
        long now = System.nanoTime();
        long time = now - lastRefillTime;
        double tokenToAdd = (time/1e9) * refillRatePerSecond;
        if(tokenToAdd >= 1)
        {
            currentTokens  = (int)Math.min(capacity, currentTokens + tokenToAdd);
            lastRefillTime = now;
        }
    }
}