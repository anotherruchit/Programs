package Strings;

/**
 * Created by ruchitmehta on 8/19/17.
 * Problem Statement - Given a encoded string - 2[ab]2[2[cd]ab]xy, decode it to
 *                      ababcdcdabcdcdabxy
 * TODO:
 */
public class DecodeString {
    static int start = 0;
    public static void main(String args[]){
//        System.out.println(decodeString("2[ab]2[cd]"));
        System.out.println(decodeString("2[2[cd]ab]"));

    }

    public static String decodeString(String encoded){

        char[] encodedArray = encoded.toCharArray();
        StringBuilder resultString = new StringBuilder();
        int repetition = 0;
        String word = "";
        while(start < encodedArray.length){

            System.out.println("reading character " + encodedArray[start]);
            if(Character.isDigit(encodedArray[start])){
                // Nested condition
                repetition = getNumber(encodedArray);
                System.out.println("repetition " + repetition);
            } else {
                word = getString(encodedArray);
                System.out.println("word " + word);
            }

            if(repetition > 0){
                for(int i = 0; i < repetition; i++){
                    resultString.append(word);
                }
            }
        }
        return resultString.toString();
    }

    public static String getString(char[] encodedArray){
        StringBuilder builder = new StringBuilder();
        System.out.println("start position " + start);
        while(encodedArray[start] != ']'){
            builder.append(encodedArray[start]);
            start++;
        }
        start++;
        System.out.println("word extracted " + builder.toString());
        return builder.toString();
    }

//    2[2[cd]ab]
    public static int getNumber(char[] encodedArray){
        StringBuilder builder = new StringBuilder();
        while(encodedArray[start] != '['){
            System.out.println("checking char " + encodedArray[start]);
            builder.append(encodedArray[start]);
            start++;
        }
        start++;
        return Integer.parseInt(builder.toString());
    }
}
