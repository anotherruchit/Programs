package Strings;

/**
 * Created by dharabavishi on 7/3/17.
 * http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 */
public class StringToIntegerATOI {

    public static void main(String args[]){
        StringToIntegerATOI atoi = new StringToIntegerATOI();
        System.out.println(atoi.atoi("4321"));
    }

    public int atoi(String str){
        if(str == null || str.length() < 1)
            return 0;

        int index = 0;
        long num;
        int n = str.length();
        boolean sign = true;

        while(index < n && str.charAt(index) == ' '){
            index++;
        }

        if(index == n){
            return 0;
        }

        if(str.charAt(index) == '-'){
            sign = false;
            index++;
        }
        if(str.charAt(index) == '+')
            index++;

        num = 0;

        while(index < n && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            num = Math.abs(num);
            num = num * 10 + str.charAt(index) - '0';

            if(!sign)
                num = -num;

            if(num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            index++;
        }
        return (int)num;
    }
}
