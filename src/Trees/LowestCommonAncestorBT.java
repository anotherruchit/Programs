package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ruchitmehta
 * https://www.youtube.com/watch?v=13m9ZCB8gjw
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorBT {
    public static void main(String args[]){
        LowestCommonAncestorBT tree = new LowestCommonAncestorBT();
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(15);
        n2.left = n5;
        n2.right = n6;
        System.out.println(tree.lowestCommonAncestor(root, n3, n4).data);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){

        if(root == null)
            return null;

        if((root.data == n1.data) || (root.data == n2.data))
            return root;

        TreeNode left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode right = lowestCommonAncestor(root.right, n1, n2);

        if(left != null && right != null)
            return root;

        return (left == null) ? right : left;
    }
}
