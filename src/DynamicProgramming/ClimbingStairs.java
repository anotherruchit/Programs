package DynamicProgramming;

/**
 * Created by dharabavishi on 7/1/17.
 * https://leetcode.com/articles/climbing-stairs/ (editorial solution)
 * https://www.interviewbit.com/problems/stairs/
 */
public class ClimbingStairs {

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
        if(n == 1)
            return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        // check the for loop
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String args[]){

        // Recursion with memoization
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println("Number of ways to climb 5 stairs : " +stairs.climbStairs(5));

        // dynamic programming
        System.out.println("Number of ways to climb 5 stairs : " +stairs.dynamicClimbStairs(5));
    }
}

