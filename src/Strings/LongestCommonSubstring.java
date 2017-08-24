package Strings;

/**
 * Created by ruchitmehta on 8/24/17.
 * http://www.geeksforgeeks.org/longest-common-substring/
 * Problem Statement: Input : X = "GeeksforGeeks", y = "GeeksQuiz"
                    Output : 5
                    The longest common substring is "Geeks" and is of
                    length 5.
 */
public class LongestCommonSubstring {
    public static void main(String args[]){
        System.out.println(longestCommonSubstring("GeeksforGeeks", "GeeksQuiz"));
    }

    public static int longestCommonSubstring(String str1, String str2){
        char[] xArray = str1.toCharArray();
        char[] yArray = str2.toCharArray();
        int x = xArray.length, y = yArray.length;
        int[][] result = new int[x+1][y+1];
        int length = 0;

        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if(i == 0 || j == 0)
                    result[i][j] = 0;
                else if(xArray[i-1] == yArray[j-1]){
                    result[i][j] = result[i-1][j-1] + 1;
                    length = Math.max(length, result[i][j]);
                }
                else {
                    result[i][j] = 0;
                }
            }
        }
        return length;
    }
}
