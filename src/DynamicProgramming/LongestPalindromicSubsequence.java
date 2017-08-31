package DynamicProgramming;

/**
 * Created by ruchitmehta on 8/24/17.
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
 * https://www.youtube.com/watch?v=_nCsPn7_OgI
 */
public class LongestPalindromicSubsequence {
    public static void main(String args[]){
        System.out.println(longestPalindromicSubsequence("agbdba"));
        System.out.println(longestPalindromicSubsequence("bbbab"));
    }

    public static int longestPalindromicSubsequence(String str){
        if(str == null || str.length() == 0)
            return 0;

        int n = str.length();
        int[][] longestPS = new int[n][n];

        for(int i = 0; i < n; i++){
            longestPS[i][i] = 1;
        }

        for(int l = 2; l <= n; l++){
            for(int i = 0; i < n - l + 1; i++){
                int j = i + l - 1;

                if(l == 2 && str.charAt(i) == str.charAt(j)){
                    longestPS[i][j] = 2;
                } else if(str.charAt(i) == str.charAt(j)){
                    longestPS[i][j] = longestPS[i+1][j-1] + 2;
                } else {
                    longestPS[i][j] = Math.max(longestPS[i+1][j],
                                            longestPS[i][j-1]);
                }
            }
        }

        return longestPS[0][str.length()-1];
    }
}
