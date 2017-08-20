package Strings;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
 * http://javabypatel.blogspot.in/2016/03/print-all-interleaving-of-given-two-strings.html
 */
public class InterweavingStrings {
    public static void main(String args[]){
        interweavingStrings("AB", "CD", "");
    }

    public static void interweavingStrings(String str1, String str2, String interweaving){

        //If string 1 is null then print string 2 and return
        if(str1 == null){
            System.out.println(str2);
            return;
        }

        //If string 2 is null then print string 1 and return
        if(str2 == null){
            System.out.println(str1);
            return;
        }

        //if string 1 and string 2 length became 0, it means all characters from str1 and str2 is present in interleaving, print interleavingString.
        if(str1.length() == 0 && str2.length() == 0){
            System.out.println(interweaving);
        }

        //pick characters from string 1 until string 1 length is empty.
        if(str1.length() > 0){
            //pick character from string 1 and append it in interleavingString string. In next recursive call remove picked character from string 1.
            interweavingStrings(str1.substring(1), str2, interweaving + str1.charAt(0));
        }

        //pick characters from string 2 until string 2 length is empty.
        if(str2.length() > 0)
            interweavingStrings(str1, str2.substring(1), interweaving + str2.charAt(0));
    }
}
