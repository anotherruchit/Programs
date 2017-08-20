package Arrays;

/**
 * Created by ruchitmehta on 8/16/17.
 * https://www.youtube.com/watch?v=xeg-ISUYdh4
 */
public class RemoveDuplicatesFromCharArray {
    public static void main(String args[]){
        char[] array = {'b', 'u', 't', 't', 'e', 'r'};
        int newSize = removeDuplicates(array, array.length);

        for(int i = 0; i < newSize; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static int removeDuplicates(char[] array, int currentSize){
        int start = 0;
        while(start < currentSize){
            int removed = removeFromTail(array, currentSize, start + 1, array[start]);
            currentSize = currentSize - removed;
            start++;
        }
        return currentSize;
    }

    public static int removeFromTail(char[] array, int currentSize, int start, char toBeRemoved){
        int source = start;
        int target = start;
        int removed = 0;
        while(source < currentSize){
            if(array[source] == toBeRemoved){
                System.out.println("removing " + array[source]);
                removed++;
            } else {
                array[target] = array[source];
                target++;
            }
            source++;
        }
        return removed;
    }
}
