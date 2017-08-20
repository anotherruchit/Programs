package Arrays;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 8/11/17.
 * http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/ - counter-clockwise direction
 * another way of doing it - http://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 *                              transpose of matrix and reverse column
 */
public class Rotate2DArray {
    public static void main(String args[]){
        int[][] array = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate90Array(array);
        System.out.println(Arrays.deepToString(array));
    }

    // clockwise direction
    static int[][] rotate90Array(int[][] array){

        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.0); j++) {
                System.out.println("for value " + i + " " + j);
                int temp = array[i][j];
                array[i][j] = array[n-1-j][i];
                array[n-1-j][i] = array[n-1-i][n-1-j];
                array[n-1-i][n-1-j] = array[j][n-1-i];
                array[j][n-1-i] = temp;
            }
        }

        return array;
    }
}
