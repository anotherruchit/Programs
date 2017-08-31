package Strings;

/**
 * Created by ruchitmehta on 8/23/17.
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/
 * Problem statment: Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 *                  length of s is 1000.
 *                  Example: Input: "babad", Output: "bab" (Note: aba is also correct answer
 *                          Input: "cbbd", Output: "bb"
 */

public class LongestPalindrome {
    public static void main(String args[]){
        System.out.println(longestPalindrome("ccbbc"));
    }

    public static String longestPalindrome(String str){
        if(str == null || str.length() == 0)
            return "";

        int start = 0, end = 0;
        for(int i = 0; i < str.length(); i++){
            int len1 = extendFromCenter(str, i, i);
            int len2 = extendFromCenter(str, i, i+1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int extendFromCenter(String str, int left, int right){
        int l = left, r = right;
        while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)){
            r++;
            l--;
        }

        return r - l - 1;
    }
}
