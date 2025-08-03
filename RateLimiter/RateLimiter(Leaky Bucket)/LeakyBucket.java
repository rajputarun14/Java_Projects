import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class LeakyBucket{
    Queue<Request> queue;
    private int capacity;
    private int leakRate;
    private int currentSize;
    private LocalDateTime date;
    
    ArrayBlockingQueue<Request> threadSafe ;

    public LeakyBucket(int capacity, int leakRate)
    {   
        this.capacity = capacity;
        this.leakRate = leakRate;
        queue = new LinkedList<>();
        currentSize = 0;
        date = LocalDateTime.now();
        threadSafe = new ArrayBlockingQueue<>(capacity);
    }

    public void serverRequest(Request req) {
        if(currentSize == capacity && threadSafe.remainingCapacity() == 0){
            System.out.println("Can't server more req");
            return;
        }
        queue.add(req);
        threadSafe.add(req);
        currentSize++;
        if(LocalDateTime.now().getMinute() - date.getMinute() >= 5)
        {
            leakRequest();
            date = LocalDateTime.now();
        }
    }

    public void leakRequest()
    {
        for(int i=0;i<leakRate; i++)
        {
            if(currentSize != 0 && threadSafe.remainingCapacity() != 0)
            {
                queue.poll();
                threadSafe.poll();
                currentSize--;
            }else{
                break;
            }
        }
    }
}