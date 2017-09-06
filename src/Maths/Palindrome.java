package Maths;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://javabypatel.blogspot.com/2017/05/check-number-is-palindrome-in-java.html
 */
public class Palindrome {
    public static void main(String args[]){
        if(isPallindrome(432344))
            System.out.println("Number is Palindrome");
        else
            System.out.println("Number is not Pallindrime");

        System.out.println(isPalin(1441));
    }

    // Without using extra space - http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
    static boolean isPalin(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        System.out.println("div is "+ div);

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;

            div /= 100;
            System.out.println("x is " + x);
            System.out.println("div is " + div);
        }

        return true;
    }

    static boolean isPallindrome(long num){
        long rNumber = reverseNumber(num);

        if(num == rNumber)
            return true;
        else
            return false;
    }

    static long reverseNumber(long num){
        // 432
        long last, newNumber = 0;
        while(num > 0){
             last = num % 10;
             newNumber = newNumber * 10 + last;
             num = num / 10;
        }
        System.out.println("Reverse Number is " + newNumber);
        return newNumber;
    }

    // Approach 2 - Convert Number to String and then compare
    public static boolean isPalindrome(int number){
        if(number < 0){
            System.out.println("Invalid number");
            return false;
        }
        String originalString = String.valueOf(number);
        String reversedString = "";
        for (int i = originalString.length()-1; i >= 0; i--) {
            reversedString += originalString.charAt(i);
        }

        return originalString.equals(reversedString);
    }

    // Approach 3 - check whether string is palindrome without reversing original string and by comparing the characters
    //              of original string from both end that is from front and back together
    public static boolean isPal(int number){
        if(number < 0){
            System.out.println("Invalid number");
            return false;
        }
        String originalString = String.valueOf(number);

        int pointer1 = 0;
        int pointer2 = originalString.length()-1;

        while(pointer1 < pointer2) {
            if(originalString.charAt(pointer1) != originalString.charAt(pointer2)) {
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;

    }
}
