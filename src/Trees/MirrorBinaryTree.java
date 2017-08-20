package Trees;

import java.util.Stack;

/**
 * Created by ruchitmehta on 7/30/17.
 * Application of Mirror Tree - http://javabypatel.blogspot.com/2017/02/check-whether-tree-is-foldable-or-not.html
 */
public class MirrorBinaryTree {
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

        TreeNode n5 = new TreeNode(12);
        n4.right = n5;

        TreeNode n6 = new TreeNode(7);
        n2.right = n6;

        inOrderTraversal(root);
        TreeNode newRoot = mirrorTree(root);
        System.out.println();
        inOrderTraversal(newRoot);
        System.out.println();
        System.out.println(isMirrorTree(root, newRoot));
    }

    public static void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static TreeNode mirrorTree(TreeNode root){
        if (root == null)
            return null;

        TreeNode newNode = new TreeNode(root.data);
        /* do the subtrees */
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        /* swap the left and right pointers */
        newNode.left = right;
        newNode.right = left;

        return newNode;
    }

     static boolean isMirrorTree(TreeNode a, TreeNode b){

        if(a == null && b == null)
            return true;
//        System.out.println("comparing " + a.data + " " + b.data);
        if (a == null || b == null)
            return false;

         return a.data == b.data
                 && isMirrorTree(a.left, b.right)
                 && isMirrorTree(a.right, b.left);
    }
}
