//package Strings;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by ruchitmehta on 8/11/17.
// * https://leetcode.com/problems/find-all-anagrams-in-a-string/
// * https://www.careercup.com/question?id=5697722133774336
// *
// */
//public class AllAnagramsInString {
//    public static void main(String args[]){
//        System.out.println(findAllAnagrams("abab", "ab").toString());
//    }
//
//    public static List<Integer> findAnagrams(String s, String p) {
//        int[] chars = new int[26];
//        List<Integer> result = new ArrayList<>();
//
//        if (s == null || p == null || s.length() < p.length())
//            return result;
//        for (char c : p.toCharArray())
//            chars[c-'a']++;
//        String str = str.sub
//        int start = 0, end = 0, count = p.length();
//        // Go over the string
//        while (end < s.length()) {
//            System.out.println(Arrays.toString(chars));
//            // If the char at start appeared in p, we increase count
//            if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
//                count++;
//            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
//            if (--chars[s.charAt(end++)-'a'] >= 0)
//                count--;
//            if (count == 0)
//                result.add(start);
//
//        }
//
//        return result;
//    }
//
//
//    public static List<Integer> findAllAnagrams(String str, String pattern){
//        int[] chars = new int[256];
//        List<Integer> result = new ArrayList<>();
//
//        if(str == null || pattern == null || str.length() < pattern.length())
//            return result;
//
//        chars = getPatternHash(pattern);
//        int start = 0, end = 0;
//
//        for(int i = 0; i < str.length(); i++){
////            TODO
//        }
//        return null;
//    }
//
//    public static int[] getPatternHash(String pattern){
//
//        int[] patternCount = new int[256];
//
//        for(int i = 0; i < pattern.length(); i++){
//                patternCount[pattern.charAt(i)-'a']++;
//        }
//
//        System.out.println(Arrays.toString(patternCount));
//        return patternCount;
//    }
//
//
//}
