import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by dharabavishi on 6/20/17.
 * http://www.geeksforgeeks.org/sort-elements-basis-number-factors/
 * Time Complexity: O(n √n)
 */
public class Trial {
    int numberFactors, index;

    public Trial(int index, int countOfFactors){
        this.index = index;
        this.numberFactors = countOfFactors;
    }

    public static int countFactors(int n){
        int count=0; // number of factors
        int sq = (int)Math.sqrt(n);
        if (sq * sq == n){
            count++;
        }

        for (int i = 1; i < Math.sqrt(n); i++){
            // increment count by 2 since i and n/i both are factors
            if(n % i == 0){
                count += 2;
            }
        }
//        System.out.println("Returning number of factors for " + n + " : " + count);
        return count;
    }

    public static void printOnBasisOfFactors(int[] arr, int length){
        Trial num[] = new Trial[length];

        for(int i = 0; i < length; i++){
            num[i] = new Trial(i, countFactors(arr[i]));
        }

        Arrays.sort(num, new Comparator<Trial>() {
            @Override
            public int compare(Trial e1, Trial e2) {
                if(e1.numberFactors == e2.numberFactors)
                    return e1.index < e2.index ? -1 : 1;
                if(e1.numberFactors > e2.numberFactors)
                    return -1;
                else
                    return 1;
            }
        });

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[num[i].index] + " ");
        }
    }


    public static void main(String args[]){
        int arr[] = {5, 11, 10, 20, 9, 16, 23};

        printOnBasisOfFactors(arr, arr.length);
    }
}
