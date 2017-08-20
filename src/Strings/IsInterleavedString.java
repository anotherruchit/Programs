package Strings;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://javabypatel.blogspot.in/2016/03/check-if-given-string-is-interleaved-of-two-other-strings.html
 */
public class IsInterleavedString {
    public static void main(String args[]){
        System.out.println(isInterleaved("AB", "MN", "MABN"));
    }

    public static boolean isInterleaved(String str1, String str2, String strToCheck){
        if(str1.length() + str2.length() != strToCheck.length()){
            return false;
        }

        int i = 0, j = 0, k = 0;
        while (k < strToCheck.length()){
            if(i < str1.length() && str1.charAt(i) == strToCheck.charAt(k)){
                i++;
            } else if (j < str2.length() && str2.charAt(j) == strToCheck.charAt(k)){
                j++;
            } else {
                return false;
            }

            k++;
        }

        if(str1.length() == i && str2.length() == j && strToCheck.length() == k){
            return true;
        } else
            return false;
    }
}
