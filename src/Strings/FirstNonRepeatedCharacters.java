package Strings;

/**
 * Created by ruchitmehta on 8/12/17.
 * https://www.careercup.com/question?id=5754891470372864
 */
public class FirstNonRepeatedCharacters {
    public static void main(String args[]){
        System.out.println(firstNonRepeating("abcdzabcd"));
    }

    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters
       in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length();  i++)
            count[str.charAt(i)]++;
    }

    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */
    static char firstNonRepeating(String str)
    {
        if(str.length() == 0 || str == null){
            return ' ';
        }

        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length();  i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                index = i;
                break;
            }
        }

        return str.charAt(index);
    }

}
