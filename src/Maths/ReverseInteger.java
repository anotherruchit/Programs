package Maths;

/**
 * Created by ruchitmehta
 * https://leetcode.com/problems/reverse-integer/#/description
 *
 * Some good questions:
 *      If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *      Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 *      For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class ReverseInteger {
    public static void main(String args[]){

        System.out.println(reverseInteger(10003));
    }

    public static int reverseInteger(int num){
        if(num == 0){
            return num;
        }

        int result = 0, tail, newResult;

        while(num != 0){
            tail = num % 10;
            newResult = result * 10 + tail;
            // if overflow exists, the newResult will not equal to previous one.
            if((newResult - tail) / 10 != result)
                return 0;
            result = newResult;
            num = num/10;
        }
        return  result;
    }
}
