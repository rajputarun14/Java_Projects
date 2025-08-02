import java.util.Arrays;
import java.util.HashSet;


public class PrimeNumbers {
    private static int limit = 100000000;

    public static boolean[] getPrime(int lim) {
        boolean[] isPrime = new boolean[lim];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < lim; i++) { // '< lim' instead of '<=limit'
            if (isPrime[i]) {
                for (int j = i * i; j < lim; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String args[]) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
            numbers.add(i * i);
        }
        boolean[] isPrimes = getPrime(limit);
        HashSet<Integer> result = new HashSet<>();
        for (int num : numbers) {
            if (num < limit && isPrimes[num]) {
                result.add(num);
            }
        }
        System.out.println(result);
    }
}