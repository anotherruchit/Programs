package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharabavishi on 7/3/17.
 * https://leetcode.com/problems/restore-ip-addresses/#/solutions
 *  Problem Statement : Given “25525511135”,
                        return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 * TODO: https://www.interviewbit.com/problems/valid-ip-addresses/ - better solution
 */
public class RestoreIPAddress {

    public static void main(String args[]){
        List<String> list = restoreIPAddress("12321232");
        System.out.println(list.toString());

        // error condition
        list = restoreIPAddress("123212A32");
        System.out.println(list.toString());

        //error condition
        list = restoreIPAddress("123");
        System.out.println(list.toString());
    }

    public static ArrayList<String> restoreIPAddress(String s){
        ArrayList<String> res = new ArrayList<>();
        int len = s.length();

        if(s.length() > 12)
            return res;
        if(s.length() < 4)
            return res;

        for(int i = 1; i < 4 && i < len-2; i++){
            for(int j = i+1; j < i+4 && j < len-1; j++){
                for(int k = j+1; k < j+4 && k < len; k++){
                    String s1 = s.substring(0, i),
                            s2 = s.substring(i, j),
                            s3 = s.substring(j, k),
                            s4 = s.substring(k, len);
                    // startIndex: inclusive, endIndex: exclusive


                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValid(String s){
        int number;
        try{
            number = Integer.parseInt(s);
        } catch (NumberFormatException nfe){
            System.out.println(s + " is not a number");
            return false;
        }
        if(s.length() > 3 ||number > 255 || s.charAt(0) == '0' && s.length() > 1 ||
                s.length() == 0)
            return false;

        return true;

    }
}
