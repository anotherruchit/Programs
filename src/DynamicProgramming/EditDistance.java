package DynamicProgramming;

/**
 * Created by dharabavishi on 7/3/17.
 * https://leetcode.com/problems/edit-distance/#/solutions
 *
 *  Time Complexity: O(m x n)
    Auxiliary Space: O(m x n)
 */
public class EditDistance {
    public static void main(String args[]){
        String word1 = "sunday";
        String word2 = "saturday";
        System.out.println(minDistance(word1, word2));
        System.out.println(editDistance(word1, word2, word1.length(), word2.length()));
    }

    // dynamic programming
    public static int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();

        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();

        // Create a table to store results of subproblems
        int[][] cost = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i+1][j+1] = cost[i][j];
                else{
                    int a = cost[i][j];
                    int b = cost[i][j+1];
                    int c = cost[i+1][j];
                    cost[i+1][j+1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i+1][j+1]++;
                }
            }
        }
        return cost[m][n];
    }


    // Recursion method
    /* http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
    * time complexity : O(3^m) */
    public static int editDistance(String word1, String word2, int m, int n){

        if(m == 0)
            return n;
        if(n == 0)
            return m;

        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return editDistance(word1, word2, m-1, n-1);
        }

        return 1 + min(editDistance(word1, word2, m, n-1),
                editDistance(word1, word2, m-1, n),
                editDistance(word1, word2, m-1, n-1));
    }

    static int min(int x, int y, int z){
        if(x < y && x < z ) return x;
        if(y < x && y < z) return y;
        return z;
    }
}
