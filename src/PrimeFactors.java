import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruchitmehta.
 * http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
 * This program will print 'all' prime factors of a number (i.e. including repetition). This is different than printing
 * all 'unique' prime factors of a number
 */
public class PrimeFactors {
    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        System.out.println("Factors are: " + factors.toString());
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Primefactors of 44");
        for (Integer integer : primeFactors(44)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 3");
        for (Integer integer : primeFactors(3)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 12246");
        for (Integer integer : primeFactors(12246)) {
            System.out.println(integer);
        }
    }

}

