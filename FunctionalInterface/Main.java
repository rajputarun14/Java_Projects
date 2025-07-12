@FunctionalInterface
interface MyPrinter {
    void print(String message);  // Only one abstract method
}

public class Main {
    public static void main(String[] args) {
        // Lambda expression to implement the interface
        MyPrinter printer = (msg) -> System.out.println("Printing: " + msg);

        // Call the method
        printer.print("Hello Java!");
    }
}
