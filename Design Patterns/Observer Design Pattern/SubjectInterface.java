public interface SubjectInterface {
    public void addObserver(Observer observer);
    public void deleteObserver(Observer observer);
    public void notifyObserver(String message);
}
