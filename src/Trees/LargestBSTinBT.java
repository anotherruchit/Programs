package Trees;

/**
 * Created by ruchitmehta on 7/28/17.
 * https://www.youtube.com/watch?v=4fiDs7CCxkc
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LargestBSTInBinaryTree.java
 */
public class LargestBSTinBT {

    public static void main(String args[]){

        LargestBSTinBT tree = new LargestBSTinBT();

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

        int largestBSTSize = tree.islargestBST(root);

        System.out.println("largest size " + largestBSTSize);
        assert largestBSTSize == 8;
    }

    public int islargestBST(TreeNode root){
        MinMax m = largest(root);
        return m.size;
    }

    public MinMax largest(TreeNode root){

        //if root is null return min as Integer.MAX and max as Integer.MIN
        if(root == null){
            return new MinMax();
        }

        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax = largest(root.right);

        MinMax m = new MinMax();

        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST.
        //Return false and max size of left and right subtree to parent
        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min <= root.data)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }

        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
        System.out.println("setting size : " + m.size + " for node " + root.data);

        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left != null ? leftMinMax.min : root.data;

        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right != null ? rightMinMax.max : root.data;

        return m;
    }

    class MinMax{
        int min, max, size;
        boolean isBST;

        public MinMax(){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
            isBST = true;
        }
    }
}
