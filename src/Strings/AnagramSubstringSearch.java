package Strings;

import java.util.HashMap;

/**
 * Created by ruchitmehta on 8/15/17.
 * Find all the Anagrams of a particular string in the another string
 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * TODO: https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/
 * Also, know as - find all anagrams of a needle in the haystack
 * AKA: all anagrams in string
 */
public class AnagramSubstringSearch {
    private static final int MAX = 256;
    public static void main(String args[]){
        allAnagramsInHaystack("abc", "abcbca");
        allAnagramsInHaystack("ab", "abab");
        allAnagramsInHaystack("abc", "cbaebabacd");
    }

    public static void allAnagramsInHaystack(String needle, String haystack){
        if(needle.length() > haystack.length()){
            return;
        }

        int[] needleCount = new int[MAX], haystackCount = new int[MAX];

        for(int i = 0; i < needle.length(); i++){
            needleCount[needle.charAt(i)]++;
            haystackCount[haystack.charAt(i)]++;
        }

        int i;
        for(i = needle.length(); i < haystack.length(); i++){
            // Compare counts of current window of haystack with
            // counts of needle
            if(compare(needleCount, haystackCount)){
                System.out.println("Needle Anagram is " + haystack.substring(i - needle.length(), i) + " at location "
                                + (i - needle.length()));
            }

            // Add current character to current window
            haystackCount[haystack.charAt(i)]++;
            // Remove the first character of previous window
            haystackCount[haystack.charAt(i-needle.length())]--;
        }

        // Check for the last window in text
        if(compare(needleCount, haystackCount)){
            System.out.println("Needle Anagram is " + haystack.substring(i - needle.length(), i) + " at location "
                    + (i - needle.length()));
        }
    }

    private static boolean compare(int[] needleCount, int[] haystackCount){
        for(int i = 0; i < MAX; i++){
            if(needleCount[i] != haystackCount[i]){
                return false;
            }
        }
        return true;
    }
}
