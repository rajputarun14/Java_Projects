import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String args[])
    {
        MyFunctionalInterface task = () -> System.out.println("Hello World");
        task.performtask();

        /*
        Function<T, R>
        Purpose: Takes one input of type T, returns a result of type R.
        Method: R apply(T t)
         */
        Function<String, Integer> func = str -> str.length();
        System.out.println(func.apply("Arun"));

        /*
        Predicate<T>
        Purpose: Takes one input and returns a boolean.
        Method: boolean test(T t) 
        */
        Predicate<Integer> isEven = num -> num%2==0;
        System.out.println(isEven.test(26));
        System.out.println(isEven.test(25));

        /*Consumer<T>
        Purpose: Takes one input, performs an action, returns nothing (void).
        Method: void accept(T t) */
        Consumer<String> cons = str -> System.out.println(str + str);
        cons.accept("Arun");

        /*Supplier<T>
        Purpose: Takes no input, returns a value of type T.
        Method: T get() */
        Supplier<String> supp = () -> "Hello";
        System.out.println(supp.get());
    }
}