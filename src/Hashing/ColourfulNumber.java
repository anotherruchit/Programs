package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ruchitmehta on 6/27/17.
 * https://www.interviewbit.com/problems/colorful-number/
 * Problem Statement: A number can be broken into different contiguous sub-subsequence parts.
                    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
                    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 TODO:
 */
public class ColourfulNumber {

    public static int colorful(int A){
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        int num;
        while(A != 0){
            num = A % 10;
            numbers.add(num);
            A = A/10;
        }

        System.out.println(numbers.toString());
        Collections.reverse(numbers);
        System.out.println(numbers.toString());

        int n = numbers.size();

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int prod = 1;
                for(int k = i ; k <= j ; k++){
                    prod = prod * numbers.get(k);
                }

                if(hashSet.contains(prod))
                    return 0;
                else{
                    hashSet.add(prod);
                }
            }
        }
        return 1;

    }
    public static void main(String args[]){
        if(colorful(1234) == 1){
            System.out.println("Colorful number");
        }
        else {
            System.out.println("Not so colorful number");
        }

        if(colorful(4589) == 1){
            System.out.println("Colorful number");
        }
        else {
            System.out.println("Not so colorful number");
        }
    }
}
