package Arrays;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 9/5/17.
 */
public class MergeTwoSortedArrays {
    public static void main(String args[]){
        int[] A = {1, 5, 7, 12, -1, -1, -1, -1};
        int[] B = {0, 3, 5, 14};
        System.out.println(Arrays.toString(mergeTwoSortedArrays(A, A.length - B.length, B, B.length)));
    }

    public static int[] mergeTwoSortedArrays(int[] A, int m, int[] B, int n){
        if(m == 0)
            return B;
        if(n == 0)
            return A;

        while(m > 0 && n > 0){
            if(B[n - 1] > A[m - 1]){
                A[m + n - 1] = B[n - 1];
                n--;
            } else {
                A[m + n - 1] = A[m - 1];
                m--;
            }
        }

        if(n > 0){
            A[m + n - 1] = B[n - 1];
        }

        return A;
    }
}
