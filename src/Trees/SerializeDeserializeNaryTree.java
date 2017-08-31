package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ruchitmehta on 8/28/17.
 * Problem Statement: Serialize and deserialize n-ary tree
 *
 */
public class SerializeDeserializeNaryTree {

    private int currIndex = 0;

    static class NaryTreeNode{
        char c;
        List<NaryTreeNode> children = new LinkedList<>();
        int index = 0;
        public NaryTreeNode(char c){
            this.c = c;
        }

        public void addChild(NaryTreeNode node){
            children.add(index++, node);
        }
    }



}
