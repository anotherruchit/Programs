package Maths;

/**
 * Created by ruchitmehta on 9/3/17.
 */
public class Factorial {
    public static void main(String args[]){
        System.out.println(factorial(5));
    }

    public static int factorial(int n){
        if(n < 0)
            return 0;
        int fact = 1;

        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }

        return fact;
    }
}
