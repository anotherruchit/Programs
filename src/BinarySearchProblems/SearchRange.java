package BinarySearchProblems;

import java.util.ArrayList;

/**
 * Created by dharabavishi on 6/21/17.
 * https://www.interviewbit.com/problems/search-for-a-range/
 */
public class SearchRange {

    public static void main(String args[]){
        int[] array = {3, 5, 12, 12, 12, 12, 88, 90};
        searchRange(array, 12);
    }


    public static void searchRange(final int[] A, int B) {

        int low, up;
        ArrayList<Integer> res = new ArrayList<>();

        low = lowerBound(A, 0, A.length - 1, B);

        if (low == -1) {
            res.add(-1);
            res.add(-1);
//            return res;
        }

        up = upperBound(A, 0, A.length - 1, B);

        for(int i = low; i <= up; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int lowerBound(final int[] A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int low = -1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;

            if (num < A[mid]) {
                end = mid - 1;
            } else if (num > A[mid]) {
                start = mid + 1;
            } else {
                low = mid;
                end = mid - 1;
            }

            steps /= 2;
        }

        return low;

    }

    public static int upperBound(final int[] A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int up = end + 1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;

            if (num < A[mid]) {
                end = mid - 1;
            } else if (num > A[mid]) {
                start = mid + 1;
            } else {
                up = mid;
                start = mid + 1;
            }

            steps /= 2;
        }

        return up;

    }
}
