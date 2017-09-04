package Arrays;

/**
 * Created by ruchitmehta on 9/1/17.
 */
public class EbayQuestion {
    public static void main(String args[]){
        System.out.println(maxSubArraySize(new int[]{12, 4, 78, 90, 45, 23, 46}));
    }

    public static int maxSubArraySize(int[] array){
        if(array == null || array.length == 0)
            return 0;

        if(array.length == 1 || array.length == 2)
            return array.length;

        int length = array.length;
        int start = 0, prev = 0, curr = 1;
        int maxSubArraySize = 0, count = 0;
        boolean isIncreasing = true;

        for(curr = 1; curr < length;){

            if(array[curr] > array[prev] && isIncreasing){
                // look for increasing order
                prev++;
                curr++;
                count++;
            } else {
                if(count > 0){

                    isIncreasing = false;
                    if(array[curr] < array[prev]){
                        // look for decreasing order
                        count++;
                        prev++;
                        curr++;
                    } else {
                        maxSubArraySize = Math.max(maxSubArraySize, count);
                        count = 0;
                        start = curr;
                        prev = curr;
                        if(start < length){
                            curr++;
                        }
                        isIncreasing = true;
                    }

                } else {
                    start++;
                    prev++;
                    curr++;
                }
            }
        }

        return maxSubArraySize;

    }
}
