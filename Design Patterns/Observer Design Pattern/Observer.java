public class Observer implements ObserverInterface{
    String name;
    public Observer(String name)
    {
        this.name = name;
    }

    @Override
    public void update(String message)
    {
        System.out.println("Update the observer obj " + this.name + " : "+message);
    }

}
