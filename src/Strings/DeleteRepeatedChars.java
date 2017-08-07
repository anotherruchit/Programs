package Strings;

/**
 * Created by ruchitmehta on 7/31/17.
 * Yelp Interview Question
 *
 */
public class DeleteRepeatedChars {
    public static void main(String args[]){
        System.out.println(reduceString("aeiou"));
        System.out.println(reduceString("aeeeiopeeu"));
    }

    /**
     *  Given a string of characters change all occurrences of
     *  two or more consecutive "e"s with a single "e".
     *  Example:
     *  Input: 'asdheeeeskaeeeleee'
     *  Output: 'asdheskaele'
     *
     * @param inputString String
     *
     * @return String
     */
    public static String reduceString(String inputString) {

        if(inputString == null || inputString.length() == 0){
            return null;
        }
        int length = inputString.length();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; ){
            if(inputString.charAt(i) != 'e'){
                builder.append(inputString.charAt(i));
                i++;
            } else {
                while(inputString.charAt(i) == 'e'){
                    i++;
                }
                builder.append('e');
            }
        }

        return builder.toString();
    }
}
