package DataStructuresAndProblems;

import java.util.Map;

/**
 * Created by ruchitmehta on 8/2/17.
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
 */
public class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isCompletedWord;
    }

    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insert(String word){
        TrieNode current = root;
        if(word == null || word.length() == 0)
            return;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.isCompletedWord = true;
    }

    /**
     * Iterative implementation of search into trie.
     */
    public boolean search(String str) {
        TrieNode current = root;
        if(str == null || str.length() == 0){
            return false;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }

            current = node;
        }

        return current.isCompletedWord;
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    public boolean delete(TrieNode current, String word, int index){

        if(word.length() == index){
            //when end of word is reached only delete if currrent.endOfWord is true.
            if(current.isCompletedWord == false){
                return false;
            }
            current.isCompletedWord = false;

            //if current has no other mapping then return true i.e. the node can be deleted
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index+1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
}
