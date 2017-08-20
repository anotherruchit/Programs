package Maths;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://javabypatel.blogspot.in/2017/05/count-trailing-zeros-in-factorial-of-number.html
 */
public class TrailingZeroesInFactorial {
    public static void main(String args[]){
        System.out.println(trailingZeroes(29));
    }

    public static int trailingZeroes(int num){
        if(num < 0)
            return  -1;

        int count = 0;
        for(int i = 5; i < num; i = i * 5){
            count = count + num / i;
        }

        return count;

    }
}
