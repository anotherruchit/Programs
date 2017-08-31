package Trees;

/**
 * Created by ruchitmehta on 8/28/17.
 * Problem statement: Find the leftmost node in the binary tree
 */
public class LeftMostRightMostElementInBT {
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

        TreeNode n7 = new TreeNode(10);
        n3.right = n7;
        TreeNode n8 = new TreeNode(11);
        n7.left= n8;

        System.out.println(findLeftMostNode(root).data);
        System.out.println(findRightMistNode(root).data);
    }

    public static TreeNode findLeftMostNode(TreeNode node){
        if(node == null)
            return null;
        while(node.left != null){
            node = node.left;
        }

        return node;
    }

    public static TreeNode findRightMistNode(TreeNode node){
        if(node == null)
            return null;

        while(node.right != null)
            node = node.right;

        return node;
    }
}
