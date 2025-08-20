import java.util.ArrayList;
import java.util.List;

public class Subject implements SubjectInterface {
    List<Observer> observers;

    public Subject()
    {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for(Observer ob : observers)
        {
            ob.update(message);
        }
    }

    public void publishNews(String messgae)
    {
        notifyObserver(messgae);
    }
    
}
