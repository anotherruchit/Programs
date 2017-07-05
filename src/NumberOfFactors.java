import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ruchitmehta.
 * http://www.geeksforgeeks.org/sort-elements-basis-number-factors/
 */
public class NumberOfFactors {

    int index, no_of_fact;

    public NumberOfFactors(int i, int countFactors)
    {
        index = i;
        no_of_fact = countFactors;
    }

    // method to count factors for
    // a given number n
    static int countFactors(int n)
    {
        int count = 0;
        int sq = (int)Math.sqrt(n);

        // if the number is a perfect square
        if (sq * sq == n)
            count++;

        // count all other factors
        for (int i=1; i<Math.sqrt(n); i++)
        {
            // if i is a factor then n/i will be
            // another factor. So increment by 2
            if (n % i == 0)
                count += 2;
        }

        return count;
    }

    // function to print numbers after sorting them in
    // decreasing order of number of factors
    static void printOnBasisOfFactors(int arr[], int n)
    {
        NumberOfFactors num[] = new NumberOfFactors[n];

        // for each element of input array create a
        // structure element to store its index and
        // factors count
        for (int i=0; i<n; i++)
        {
            num[i] = new NumberOfFactors(i,countFactors(arr[i]));
        }

        // sort the array of structures as defined
        Arrays.sort(num,new Comparator<NumberOfFactors>() {

            @Override
            // compare method for the elements
            // of the structure
            public int compare(NumberOfFactors e1, NumberOfFactors e2) {
                // if two elements have the same number
                // of factors then sort them in increasing
                // order of their index in the input array
                if (e1.no_of_fact == e2.no_of_fact)
                    return e1.index < e2.index ? -1 : 1;

                // sort in decreasing order of number of factors
                return e1.no_of_fact > e2.no_of_fact ? -1 : 1;
            }

        });

        // access index from the structure element and correponding
        // to that index access the element from arr
        for (int i=0; i<n; i++){
//            System.out.println("Index is " + num[i].index);
            System.out.print(arr[num[i].index]+" ");
        }

    }

    // Driver program to test above
    public static void main(String[] args)
    {

        int arr[] = {5, 11, 10, 20, 9, 16, 23};

        printOnBasisOfFactors(arr, arr.length);

    }
}
