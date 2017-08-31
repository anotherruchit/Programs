package Trees;

/**
 * Created by ruchitmehta on 8/28/17.
 * http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 */
public class DeepestLeftLeafNode {
    static TreeNode result;

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        root.left = n1;
        root.right = n2;

        // left subtree
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(2);
        n4.right = n5;

        TreeNode n6 = new TreeNode(7);
        n2.right = n6;

        deepestLeftLeafNode(root);
        System.out.println(result.data);
    }

    // A wrapper over deepestLeftLeafUtil().
    public static void deepestLeftLeafNode(TreeNode node){
        Level level = new Level();
        deepestLeftLeafNode(node, 0, level, false);
    }

    public static void deepestLeftLeafNode(TreeNode node, int lvl, Level level, boolean isLeft){
        // Base case
        if(node == null)
            return;

        // Update result if this node is left leaf and its level is more
        // than the maxl level of the current result
        if(node.left == null && node.right == null && lvl > level.maxlevel && isLeft != false){
            level.maxlevel = lvl;
            result = node;
        }

        // Recur for left and right subtrees
        deepestLeftLeafNode(node.left, lvl+1, level, true);
        deepestLeftLeafNode(node.right, lvl+1, level, false);
    }
}

class Level{
    // maxlevel: gives the value of level of maximum left leaf
    int maxlevel = 0;
}
