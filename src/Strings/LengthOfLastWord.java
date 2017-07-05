package Strings;

/**
 * Created by dharabavishi on 7/2/17.
 * https://www.interviewbit.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public static void main(String args[]){
        System.out.println(lengthOfLastWord("this is a simple problem to solve    "));
    }

    public static int lengthOfLastWord(final String A) {
        int i;

        if (A.length() == 0)
            return 0;

        int n = A.length();
        int lastWordIndex = n;
        int endIndex = n;

        i = n - 1;

        // removing any extra spaces at the end of the string
        while (i >= 0 && A.charAt(i) == ' '){
            i--;
        }

        endIndex = i;
        System.out.println("value of endindex = " + endIndex);

        for (; i >= 0; i--) {

            if (A.charAt(i) == ' ') {
                break;
            }

            lastWordIndex = i;

        }

        return Math.max(0, endIndex - lastWordIndex + 1);

    }
}
