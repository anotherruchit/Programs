package DynamicProgramming;

/**
 * Created by ruchitmehta on 7/2/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
   LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

    /* 1) Optimal Substructure: --> Recursive solution */

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */

    /*Time complexity of the above naive recursive approach is O(2^n) in worst case and
    worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0. */
    public int lcs(char[] X, char[] Y, int m, int n){
        if(m == 0 || n == 0)
            return 0;

        if(X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return max(lcs(X, Y, m-1, n), lcs(X, Y, m, n-1));
    }

    /* Utility function to get max of 2 integers */
    public int max(int a, int b){
        return (a > b) ? a : b;
    }

     /* 2) Overlapping subproblems: --> tabulation approach to avoid calculating for subproblems
     * again and again*/
     /* Dynamic Programming implementation -> https://www.youtube.com/watch?v=NnD96abizww */
     /* Time Complexity of the above implementation is O(mn) which
     is much better than the worst case time complexity of Naive Recursive implementation. */
    public int lcsMemoization(char[] X, char[] Y, int m, int n){
        int L[][] = new int[m+1][n+1];

         /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
         for(int i = 0; i <= m; i++){
             for(int j = 0; j <= n; j++){
                 if(i == 0 || j == 0){
                    L[i][j] = 0;
                 } else if(X[i-1] == Y[j-1]){
                     L[i][j] = 1 + L[i-1][j-1];
                 } else {
                     L[i][j] = max(L[i-1][j], L[i][j-1]);
                 }
             }
         }

         printLCS(L, m, n, X, Y);
         return L[m][n];
    }

    public void printLCS(int[][] L, int m, int n, char[] X, char[] Y){
        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index+1];
        lcs[index] = '\0'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X and Y are same, then
            // current character is part of LCS
            if (X[i-1] == Y[j-1])
            {
                // Put current character in result
                lcs[index-1] = X[i-1];

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of "+String.valueOf(X) +" and "+String.valueOf(Y)+" is ");
        for(int k=0;k<temp;k++)
            System.out.print(lcs[k]);
        System.out.println();

    }

    public static void main(String args[]){
        LongestCommonSubsequence seq = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS by recursion approach - " + seq.lcs(X, Y, m, n));
        System.out.println("Length of LCS by dynamic programming approach - " + seq.lcsMemoization(X, Y, m, n));
    }

}
