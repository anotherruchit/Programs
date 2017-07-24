package Arrays;

import Trees.SortedListToBST;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * Time Complexity: O(n)
 */
public class SortBinaryArray {
    public static void main(String args[]){
        SortBinaryArray sort = new SortBinaryArray();

        int arr[] = new int[]{0, 1, 0, 1, 1, 1};
        int i;

        sort.sortBinary(arr);

        System.out.print("Array after segregation is ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void sortBinary(int[] arr){
        int left = 0, right = arr.length-1;

        while(left < right){
            while(arr[left] == 0 && left < right){
                left++;
            }

            while(arr[right] == 1 && left < right){
                right--;
            }

            if(arr[left] == 1 && arr[right] == 0){
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
