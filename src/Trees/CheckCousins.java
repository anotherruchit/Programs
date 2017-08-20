package Trees;

/**
 * Created by ruchitmehta on 8/8/17.
 * http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 */
public class CheckCousins {
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

        if(areCousins(root, n4, n6))
            System.out.println("They are cousins");
        else
            System.out.printf("Not cousins");

        if(areCousins(root, n4, n3))
            System.out.println("They are cousins");
        else
            System.out.println("Not cousins");
    }

    static boolean areCousins(TreeNode root, TreeNode node1, TreeNode node2){
        // 1. The two Nodes should be on the same level
        //       in the binary tree.
        // 2. The two Nodes should not be siblings (means
        //    that they should not have the same parent
        //    Node).

        return (level(root, node1, 1) == level(root, node2, 1) && !isSibling(root, node1, node2));
    }

    // Recursive function to find level of Node 'ptr' in
    // a binary tree
    static int level(TreeNode root, TreeNode node, int level){
        // base cases
        if(root == null)
            return 0;

        if(root == node)
            return level;

        int l = level(root.left, node, level+1);
        if(l > 0)
            return l;
        return level(root.right, node, level+1);
    }

    static boolean isSibling(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null)
            return false;

        return ((root.right == node1 && root.left == node2) || (root.left == node1 && root.right == node2) ||
                isSibling(root.left, node1, node2) || isSibling(root.right, node1, node2));
    }
}
