import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharabavishi on 6/20/17.
 * http://www.geeksforgeeks.org/find-divisors-natural-number-set-1/
 */
public class FindDivisors {

    public static List<Integer> findAllDivisors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                if(n/i == i){
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(n/i);
                }
            }
        }
//        System.out.println("Factors are: " + factors.toString());
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Primefactors of 44");
        for (Integer integer : findAllDivisors(44)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 3");
        for (Integer integer : findAllDivisors(3)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 32");
        for (Integer integer : findAllDivisors(32)) {
            System.out.println(integer);
        }
        System.out.println("Primefactors of 100");
        for (Integer integer : findAllDivisors(100)) {
            System.out.println(integer);
        }
    }
}
