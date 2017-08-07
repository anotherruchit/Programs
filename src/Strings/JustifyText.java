package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruchitmehta on 7/3/17.
 */
public class JustifyText {

    public static void main(String args[]){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words, 16));
    }

    public static List<String> fullJustify(String[] words, int L){
        List<String> lines = new ArrayList<>();
        int index = 0;

        while(index < words.length){
            int count = words[index].length(); // length of the word at index
            int last = index + 1;

            while(last < words.length){
                if(words[last].length() + count + 1 > L)
                    break;

                count = count + words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;  // number of words

            // if last line or number of words in the line is 1 then left-justified
            if(last == words.length || diff == 0){
                for(int i = index; i < last; i++){
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);

                // padding extra space
                for(int i = builder.length(); i < L; i++){
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;

//                System.out.println("L is " + L + " count is " + count);
//                System.out.println("spaces " + spaces + " r is " + r);

                for(int i = index; i < last; i++){
                    builder.append(words[i]);
                    if(i < last - 1){
                        for(int j = 0; j <= (spaces + ((i-index) < r ? 1 : 0)); j++){
                            builder.append(" ");
                        }
                    }
                }
            }

            lines.add(builder.toString());
            index = last;
        }

        return lines;
    }
}
