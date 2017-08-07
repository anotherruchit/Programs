package Graphs;

import java.util.ArrayList;

/**
 * Created by ruchitmehta
 * https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
 */
public class SmallestSequenceWithPrimes {
    public static void main(String args[]){
        SmallestSequenceWithPrimes primo = new SmallestSequenceWithPrimes();
        System.out.println(primo.smallestSequenceWithPrime(2,3,5,5).toString());
        System.out.println(primo.smallestSequenceWithPrime(17,19,87,5).toString());
    }

    public ArrayList<Integer> smallestSequenceWithPrime(int a, int b, int c, int k){

        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] currValue = new int[3];
        for(int i = 0; i < 3; i++){
            currValue[i] = -1;
        }

        int[] nextBestNumber = new int[3];
        int[] primeNumber = new int[3];
        nextBestNumber[0] = primeNumber[0] = a;
        nextBestNumber[1] = primeNumber[1] = b;
        nextBestNumber[2] = primeNumber[2] = c;


        for(int j = 0; j < k; j++){
            int minNumber = Math.min(nextBestNumber[0], Math.min(nextBestNumber[1], nextBestNumber[2]));
            result.add(minNumber);

            for(int i = 0; i < 3; i++){
                if(minNumber == nextBestNumber[i]){
                    currValue[i]++;
                    nextBestNumber[i] = result.get(currValue[i])*primeNumber[i];
                    System.out.println("next best number " + nextBestNumber[i]);
                }
            }
        }

        return result;

    }

}
