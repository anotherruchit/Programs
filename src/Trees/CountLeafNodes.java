package Trees;

/**
 * Created by ruchitmehta on 7/30/17.
 */
public class CountLeafNodes {
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

        System.out.println("Leaf Nodes " + countLeafNodes(root));
        System.out.println("Total Number of Nodes " + countNodes(root));
    }

    public static int countLeafNodes(TreeNode root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return countLeafNodes(root.left) + countLeafNodes(root.right);

    }

    public static int countNodes(TreeNode root){
        if(root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
