package HeapsAndMaps;

import java.util.HashMap;

/**
 * Created by dharabavishi on 6/28/17.
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/


 */
public class CountDistinctWindow {

    public static void main(String args[]){
        int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        CountDistinctWindow counter = new CountDistinctWindow();
        counter.countDistinct(arr, k);
    }

    public void countDistinct(int arr[], int k){

        if(k > arr.length)
            return;

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // initialize distinct element  count for current window
        int dist_count = 0;

        for(int i = 0; i < k; i++){

            if(hashMap.get(arr[i]) == null){
                dist_count++;
                hashMap.put(arr[i], 1);
            } else {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }
        }

        // Print count of first window
        System.out.println(dist_count);

        // Traverse through the remaining array
        for(int i = k; i < arr.length; i++){

            // Remove first element of previous window. If there was only one occurrence, then
            // reduce distinct count.
            if(hashMap.get(arr[i-k]) == 1){
                dist_count--;
                hashMap.remove(arr[i-k]);
            } else {
                hashMap.put(arr[i-k], hashMap.get(arr[i-k]) - 1);
            }

            // Add new element of current window
            // If this element appears first time,
            // increment distinct element count
            if(hashMap.get(arr[i]) == null){
                hashMap.put(arr[i], 1);
                dist_count++;
            } else {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }

            // Print count of current window
            System.out.println(dist_count);
        }

        return;
    }
}
