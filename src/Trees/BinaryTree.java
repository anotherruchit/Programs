package Trees;

/**
 * Created by ruchitmehta on 7/30/17.
 */

class BinaryTree
{
    /* Given two trees, return true if they are
       mirror of each other */
    boolean areMirror(TreeNode a, TreeNode b)
    {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;

        // If only one is empty
        if (a == null || b == null)
            return false;

        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }

    // Driver code to test above methods
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);

        TreeNode newRoot = tree.mirrorTree(a);

        if (tree.areMirror(a, newRoot) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

     TreeNode mirrorTree(TreeNode root){
        if (root == null)
            return root;

        /* do the subtrees */
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;
    }
}