package Arrays;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ruchitmehta
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 * O(m+n)
 */
public class UnionAndIntersectionArray {
    public static void main(String args[]){
        int[] arr1 = new int[]{1, 2, 4, 5, 6};
        int[] arr2 = new int[]{2, 3, 5, 7};

        UnionAndIntersectionArray union = new UnionAndIntersectionArray();
        union.unionOfArray(arr1, arr2);
        union.intersectionArray(arr1, arr2);
    }

    public void unionOfArray(int[] arr1, int[] arr2){
        HashSet<Integer> unionSet = new HashSet<Integer>();

        // add all the unique elements to hashset
        for(int i = 0; i < arr1.length; i++){
            unionSet.add(arr1[i]);
        }

        // add all the misisng elements from array2 to hashset
        for(int i = 0; i < arr2.length; i++){
            if(!unionSet.contains(arr2[i])){
                unionSet.add(arr2[i]);
            }
        }

        System.out.println("Union of array is ");
        Iterator iterator = unionSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

    public void intersectionArray(int[] arr1, int[] arr2){
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> intersectionSet = new HashSet<Integer>();

        // add all the unique elements from 1st array
        for(int i = 0; i < arr1.length; i++){
            set1.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++){
            if(set1.contains(arr2[i]))
                intersectionSet.add(arr2[i]);
        }

        System.out.println("\nInteresection of array is: ");
        Iterator it = intersectionSet.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
