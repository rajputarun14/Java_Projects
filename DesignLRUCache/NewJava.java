import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewJava {
    public static void main(String[] args)
    {
        String s1="abc";
        String s2="abc";
        String s3= new String("abc");

      /*   System.out.println(s1 == s2);
        System.out.println(s2==s3);
        System.out.println(s1.equals(s3)); */


      
        ArrayList<Integer> ans = new ArrayList<>();


        IntStream.range(1, 11).forEach(item -> {
          //  System.out.println(item); 
            ans.add(item);
        });

        ans.stream().map(item -> item + 1).filter(item -> item %2 == 0).forEach( item -> System.out.println(item));


    }
}
