package Arrays;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 8/11/17.
 * https://www.careercup.com/question?id=5728926218321920
 */
public class SumOfAllPrimeNumbers {
    public static void main(String args[]){
        System.out.println(sumOfAllPrimes(10));
    }

    static int sumOfAllPrimes(int n){

        // array to store prime numbers
        boolean[] primes = new boolean[n+1];
        // set all the values to true
        Arrays.fill(primes, true);

        for(int i = 2; i*i <= n; i++){

            if(primes[i] == true){
                for(int j = i*2; j <= n; j=j+i){
                    primes[j] = false;
                }
            }
        }

        int sum = 0;
        for(int k = 2; k <= n; k++){
            if(primes[k])
                sum += k;
        }

        return sum;
    }
}
