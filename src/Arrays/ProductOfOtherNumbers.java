package Arrays;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 7/28/17.
 * https://www.interviewcake.com/question/java/product-of-other-numbers
 */
public class ProductOfOtherNumbers {
    public static void main(String args[]){
        System.out.println(Arrays.toString(getProductOfAllExceptAtIndex(new int[]{4, 2, 6, 3})));
        System.out.println(Arrays.toString(getProducts(new int[]{4, 2, 6, 3})));
    }

    static int[]  getProductOfAllExceptAtIndex(int[] array){

        int[] productLeft = new int[array.length];
        int[] productRight = new int[array.length];
        int[] product = new int[array.length];

        productLeft[0] = 1;
        productRight[array.length - 1] = 1;

        for(int i = 1; i < array.length; i++){
            productLeft[i] = productLeft[i-1] * array[i-1];
        }

        for(int i = array.length-2; i >= 0; i--){
            productRight[i] = productRight[i+1] * array[i+1];
        }

        for(int i = 0; i < array.length; i++){
            product[i] = productLeft[i] * productRight[i];
        }

        return product;
    }

    // space optimized approach
    static int[] getProducts(int[] array){
        if(array.length < 2)
            throw new IllegalArgumentException("array size is less than 2");

        int[] productOfAll = new int[array.length];

        int productSoFar = 1;
        for(int i = 0; i < array.length; i++){
            productOfAll[i] = productSoFar;
            productSoFar *= array[i];
        }

        productSoFar = 1;
        for(int i = array.length-1; i >= 0; i--){
            productOfAll[i] *= productSoFar;
            productSoFar *= array[i];
        }

        return productOfAll;
    }

}
