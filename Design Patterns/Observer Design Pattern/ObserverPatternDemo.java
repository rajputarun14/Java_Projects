public class ObserverPatternDemo {
    public static void main(String args[])
    {
        Observer obs1 = new Observer("obs1");
        Subject sub = new Subject();
        sub.addObserver(new Observer("obs2"));
        sub.addObserver(new Observer("obs3"));
        sub.addObserver(obs1);
        sub.addObserver(new Observer("obs4"));

        sub.notifyObserver("Lets plan Ice skating this weekend");


        System.out.println("obs1 backed out");
        sub.deleteObserver(obs1);
        sub.notifyObserver("Lets plan Ice skating this weekend Appu backed out");

    }
}
