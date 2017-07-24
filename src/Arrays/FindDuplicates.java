package Arrays;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 */
public class FindDuplicates {
    public static void main(String args[]){
        FindDuplicates duplicate = new FindDuplicates();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        duplicate.findRepeating(arr, arr_size);
    }

    public void findRepeating(int[] arr, int size){

        if(size == 0 || arr == null)
            return;
        System.out.println("Repeating elements are : ");

        for(int i = 0; i < size; i++){
            if(arr[Math.abs(arr[i])] >= 0 )
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else{
                System.out.println(Math.abs(arr[i]) + " ");
            }
        }
    }
}
