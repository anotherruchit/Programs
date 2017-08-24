package Trees;

/**
 * Created by ruchitmehta on 8/21/17.
 * Niantic Interview Question
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Problem Statement: For this problem, a path is defined as any sequence of nodes from some starting node to any node
 *                  in the tree along the parent-child connections. The path must contain at least one node and does not need to go
 *                  through the root.
 *
 * Check out: http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class MaxPathSum {
    static int maxValue;

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

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root){
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    public static int maxPathDown(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        maxValue = Math.max(maxValue, left + right + root.data);
        return Math.max(left, right) + root.data;
    }
}
