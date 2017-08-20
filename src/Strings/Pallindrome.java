package Strings;

/**
 * Created by ruchitmehta on 7/2/17.
 * https://www.interviewbit.com/problems/palindrome-string/
 */
public class Pallindrome {
    public static void main(String args[]){
        String str = "A man, a plan, a canal: Panama";
        System.out.println(palindromeCheck(str));
        System.out.println(palindromeCheck("ruchit"));
    }

    public static int palindromeCheck(String str){
        if(str.length() == 1 || str.length() == 0)
            return 0;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <  str.length(); i++){
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ||
                    (str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                builder.append(Character.toLowerCase(str.charAt(i)));

        }

        str = builder.toString();
        int n = str.length();

        for(int i = 0; i < n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1))
                return 0;
        }

        return 1;
    }
}
