package Trees;

/**
 * Created by ruchitmehta on 8/15/17.
 * https://www.youtube.com/watch?v=ey7DYc9OANo&t=876s
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class DiameterOfBinaryTree {
    public static void main(String args[]){
        TreeNode root = new TreeNode(24);
        TreeNode n1 = new TreeNode(18);
        TreeNode n2 = new TreeNode(50);
        root.left = n1;
        root.right = n2;

        // left subtree
        TreeNode n3 = new TreeNode(17);
        TreeNode n4 = new TreeNode(20);
        n1.left = n3;
        n1.right = n4;
        TreeNode n5 = new TreeNode(15);
        n3.right = n5;

        TreeNode n6 = new TreeNode(18);
        TreeNode n7 = new TreeNode(26);
        n4.left = n6;
        n4.right = n7;

        TreeNode n8 = new TreeNode(35);
        TreeNode n9 = new TreeNode(60);
        n2.left = n8;
        n3.right = n9;

        TreeNode n10 = new TreeNode(20);
        TreeNode n11 = new TreeNode(40);
        n8.left = n10;
        n8.right = n11;

        TreeNode n12 = new TreeNode(25);
        n10.right = n12;

        TreeNode n13 = new TreeNode(55);
        TreeNode n14 = new TreeNode(70);
        n9.left = n13;
        n9.right = n14;

        System.out.println("Diameter of the Tree " + getDiameterOfBT(root));
    }

    /* Method to calculate the diameter and return it to main */
    public static int getDiameterOfBT(TreeNode node){
        /* base case if tree is empty */
        if(node == null)
            return 1;

        /* get the diameter of left and right subtrees */
        int lDiameter = getDiameterOfBT(node.left);
        int rDiameter = getDiameterOfBT(node.right);

        /* get the height of left and right sub trees */
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }

    /*The function Compute the "height" of a tree. Height is the
      number of nodes along the longest path from the root node
      down to the farthest leaf node.*/
    public static int getHeight(TreeNode node){
        /* base case tree is empty */
        if(node == null){
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }


}
