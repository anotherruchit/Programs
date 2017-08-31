package Strings;

import java.util.HashSet;

/**
 * Created by ruchitmehta on 8/24/17.
 * https://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
 * Example: For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *          For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String args[]){
        System.out.println(longestSubstringWithoutRepeating("abcdabcbb"));
    }

    public static int longestSubstringWithoutRepeating(String str){
        if(str == null || str.length() == 0)
            return 0;

        int start = 0, i = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, newLength = 0;
        String maxSubstring = "";


        while(i < str.length()){
            char c = str.charAt(i);

            if(!set.contains(c)){
                set.add(c);
            } else {
                newLength = Math.max(maxLength, set.size());

                /**
                 * Just to get the first substring with max length.
                 * If we don't check the if condition and just assign value to substring at line 40
                 * then it will print dabc instead of abcd
                 */
                if(newLength > maxLength){
                    maxLength = newLength;
                    maxSubstring = str.substring(start, i);
                }

                while(start < i && str.charAt(start) != c){
                    set.remove(c);
                    start++;
                }
                start++;
            }
            i++;
        }
        maxLength = Math.max(maxLength, set.size());
        System.out.println("Max length substring " + maxSubstring);
        return maxLength;
    }

}
