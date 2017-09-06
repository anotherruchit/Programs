package DynamicProgramming;

/**
 * Created by ruchitmehta on 9/3/17.
 * https://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/
 * Problem Statement: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 *                  which minimizes the sum of all numbers along its path.
 */
public class MinimumCostPath {
    public static void main(String args[]){
        int[][] grid = new int[][] {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minimumCostPath(grid));
    }

    public static int minimumCostPath(int[][] grid){
        if(grid == null || grid.length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];

        // populate first row
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // populate first column
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // fill up the dp table
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else{
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
