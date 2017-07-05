package Strings;

/**
 * Created by dharabavishi on 7/2/17.
 * https://www.interviewbit.com/problems/palindrome-string/
 */
public class Pallindrome {
    public static void main(String args[]){
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPallindrome(str));
        System.out.println(isPallindrome("ruchit"));
    }

    public static int isPallindrome(String str){
        if(str.length() == 1)
            return 1;

        StringBuffer builder = new StringBuffer();

        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ||
                    (str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                builder.append(Character.toLowerCase(str.charAt(i)));
            }
        }

        String string = builder.toString();

        int n = string.length();

        for(int i = 0; i < n/2; i++){
            if(string.charAt(i) != string.charAt(n-i-1))
                return 0;
        }

        return 1;
    }
}
