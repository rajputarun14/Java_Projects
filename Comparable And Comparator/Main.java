import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Arun", 1, "Agra", 7));
        students.add(new Student("Varun", 2, "Agra", 8));
        students.add(new Student("Karun", 3, "Delhi", 1));

        Collections.sort(students);// for comparable 


        Collections.sort(students, new RollNumberComparator()); // for comparator
        System.out.println(students);
    }
    
}
