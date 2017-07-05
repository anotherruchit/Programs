package BinarySearchProblems;

/**
 * Created by dharabavishi on 6/21/17.
 * https://www.interviewbit.com/problems/square-root-of-integer/
 */
public class SquareRoot {

    public static void main(String args[]){
        int index = findsqrt(16);
        System.out.println("Element found at location: " + index);
        index = findsqrt(20);
        System.out.println("Element found at location: " + index);
    }


    public static int findsqrt(int A) {

        int low, high, root;
        int mid;
        int num;

        low = 1;
        high = A;
        root = 0;

        while (low <= high) {

            mid = (low + high) / 2;

            if (mid == A / mid && (A % mid == 0))
                return mid;

            if (mid <= A / mid) {
                root = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return root;

    }
}
