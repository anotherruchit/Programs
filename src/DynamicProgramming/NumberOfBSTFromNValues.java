package DynamicProgramming;

/**
 * Created by ruchitmehta on 8/24/17.
 * Problem Statement: Given n distinct values, how many BST can be created from those n values
 * https://www.youtube.com/watch?v=YDf982Lb84o
 * https://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/
 */
public class NumberOfBSTFromNValues {
    public static void main(String args[]){
        System.out.println(numberOfBST(2));
        System.out.println(numberOfBST(4));
    }

    public static int numberOfBST(int n){
        int[] countsOFBST = new int[n+1];

        countsOFBST[0] = 1;
        countsOFBST[1] = 1;

        if(n == 0 || n == 1){
            return countsOFBST[0];
        }

        for(int i = 2; i <= n; i++){
            for (int j = 0; j <= i - 1; j++){
                countsOFBST[i] = countsOFBST[i] + countsOFBST[j] * countsOFBST[i - j - 1];
            }
        }

        return countsOFBST[n];
    }
}
