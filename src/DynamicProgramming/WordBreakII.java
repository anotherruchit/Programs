package DynamicProgramming;

import java.util.*;

/**
 * Created by ruchitmehta on 8/9/17.
 * http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 */
public class WordBreakII {

    public static void main(String args[]){
        WordBreakII words = new WordBreakII();
        Set<String> dictionary = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

        System.out.println(words.wordBreak("catsanddog", dictionary).toString());
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }

    // array of Arraylist
    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
//            System.out.println("For length : " + (i - s.length()));
            dfs(pos, result, combined, i-s.length());
        }
    }
}
