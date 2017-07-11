package Trees;

/**
 * Created by ruchitmehta.
 * http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/
 */


public class BalancedBinaryTree {
    public static void main(String args[]){
        BalancedBinaryTree tree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(9);
        n2.right = n5;
        System.out.println(tree.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        if(getHeight(root) == -1)
            return false;
        return true;
    }

    public int getHeight(TreeNode root){
        if(root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        System.out.println("For " + root.data);
        System.out.println("left, right : " + left + " " + right);

        if(left == -1 || right == -1)
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}
