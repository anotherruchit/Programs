package Arrays;

import java.util.*;

/**
 * Created by ruchitmehta
 */
public class MatchingParanthesis {
    public static void main(String args[]){
        MatchingParanthesis para = new MatchingParanthesis();
        System.out.println(para.matchingParanthesis("{]"));
        System.out.println(para.matchingParanthesis("{}"));
        System.out.println(para.matchingParanthesis("{"));
        System.out.println(para.matchingParanthesis("{{[({})]}}"));
    }

    public boolean matchingParanthesis(String paranthesis){

        if(paranthesis == null | paranthesis.length() == 0)
            return false;

        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Stack<Character> openersStack = new Stack<>();

        for (char c : paranthesis.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.empty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();

                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openersStack.empty();

    }
}
