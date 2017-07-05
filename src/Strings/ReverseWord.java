package Strings;

/**
 * Created by dharabavishi on 7/2/17.
 */
public class ReverseWord {
    public static void main(String args[]){
        String input = "reverse this word";
        System.out.println(reverseString(input));
    }

    public static String reverseString(String input){
        char[] inputArray = input.toCharArray();
        int i = 0;
        int j = inputArray.length - 1;

        while(i < j){
            char temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }
        return new String(inputArray);
    }
}
