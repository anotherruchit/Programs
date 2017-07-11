package Trees;

/**
 * Created by ruchitmehta.
 * https://www.youtube.com/watch?v=TIoCCStdiFo
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
 */

public class LowestCommonAncestorBST {
    public static void main(String args[]){
        LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
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
        System.out.println(tree.lowestCommonAncestor(root, n3, n1).data);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null)
            return null;

        if(root.data > n1.data && root.data > n2.data)
            lowestCommonAncestor(root.left, n1, n2);
        else if (root.data < n1.data && root.data < n2.data)
            lowestCommonAncestor(root.right, n1, n2);
        else
            return root;
        return root;
    }
}
