package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by ruchitmehta
 * https://leetcode.com/problems/decode-ways/#/solutions
 */
public class DecodeWays {

    public static void main(String args[]){

        DecodeWays decode = new DecodeWays();
        System.out.println("Number of ways to decode the string are : " + decode.decodingWays("12344321"));
    }

    public int decodingWays(String s){
        if(s == null || s.length()  == 0){
            return  0;
        }

        int n = s.length();
        int[] dp = new int[n + 1]; // All positions initialized to 0
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            System.out.println(first);
            int second = Integer.valueOf(s.substring(i-2, i));
            System.out.println(second);
            if(first >= 1 && first <= 9){
                dp[i] = dp[i] + dp[i-1];
            }

            if(second >= 10 && second <= 26){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return  dp[n];
    }
}
