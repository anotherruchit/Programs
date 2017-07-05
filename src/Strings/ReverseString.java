package Strings;

/**
 * Created by dharabavishi on 7/2/17.
 * https://www.interviewbit.com/problems/reverse-the-string/
 *  A sequence of non-space characters constitutes a word.
    Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReverseString {
    public static void main(String args[]){
        System.out.println(reverseWords("trying to understand and reverse   "));
    }

    public static String reverseWords(String str){

        char[] array = str.toCharArray();
        int i, n = array.length;

        for(i = 0; i < n; i++){
            // skip all the whitespaces at the start and between the words
            while(i < n && array[i] == ' '){
                i++;
            }
            int start = i;
            int end = -1;

            while(i < n && array[i] != ' ')
                i++;

            end = i;

            if(end < start)
                break;

            reverse(array, start, end);
        }
        System.out.println();
        reverse(array, 0 , n-1);
        return removeExtraSpaces(array);
    }

    public static String removeExtraSpaces(char[] array){
        int n = array.length;
        int index = 0;
        boolean cond = false;

        for(int i = 0; i < n;){
            if(array[i] != ' '){
                array[index] = array[i];
                index++;
                cond = true;
            } else {
                if(cond){
                    array[index++] = ' ';
                }
                cond = false;
            }
            i++;
        }
        if (index - 1 >= 0 && index - 1 < n && array[index - 1] == ' ')
            index--;

        return new String(array, 0, index);
    }


    public static void reverse(char[] array, int start, int end){
        char temp;
        int i;

        for (i = 0; i < (end - start + 1) / 2; i++) {
            temp = array[start + i];
            array[start + i] = array[end - i];
            array[end - i] = temp;
        }

        System.out.println(String.valueOf(array));
    }
}
