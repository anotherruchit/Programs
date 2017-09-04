package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 7/1/17.
 * https://leetcode.com/articles/climbing-stairs/ (editorial solution)
 * https://www.interviewbit.com/problems/stairs/
 * https://www.youtube.com/watch?v=eREiwuvzaUM
 */
public class ClimbingStairs {

    public static void main(String args[]){

        // Recursion with memoization
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println("Number of ways to climb 5 stairs : " +stairs.climbStairs(5));

        // dynamic programming
        System.out.println("Number of ways to climb 5 stairs : " +stairs.dynamicClimbStairs(5));

        System.out.println(climbStairsWays(3));
    }



    static int climbStairsWays(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    static int countWays(int n, int[] memo){
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        if(memo[n] > -1){
            return memo[n];
        } else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }



    public int climbStairs(int n){
        int memo[] = new int[n+1];
        return climb_stairs(0, n, memo);
    }

    public int climb_stairs(int i, int n, int[] memo){
        if(i > n)
            return 0;
        if(i == n)
            return 1;

        if(memo[i] > 0)
            return memo[i];

        memo[i] = climb_stairs(i+1, n, memo) + climb_stairs(i+2, n, memo);
        return memo[i];
    }

    public int dynamicClimbStairs(int n){
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}

