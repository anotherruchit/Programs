package Strings;

import java.util.Arrays;

/**
 * Created by dharabavishi on 7/3/17.
 * https://www.interviewbit.com/problems/compare-version-numbers/
 */
public class CompareVersions {
    public static void main(String args[]){
        System.out.println(compareVersion("1.0", "1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("1.7.1", "1.12"));
    }

//    http://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        System.out.println(Arrays.toString(arr1));

        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                    return -1;
                }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                    return 1;
                }
            } else if(i<arr1.length){
                if(Integer.parseInt(arr1[i]) != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(Integer.parseInt(arr2[i]) != 0){
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }
}
