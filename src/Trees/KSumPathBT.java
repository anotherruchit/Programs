package Trees;

/**
 * Created by ruchitmehta on 7/29/17.
 * https://www.interviewbit.com/problems/path-sum/
 */
public class KSumPathBT {
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

        System.out.println(allKSumPaths(root,13));
    }


    // This takes BFS approach where we see all the paths from a particular node
    static boolean allKSumPaths(TreeNode root, int k){
        if(root == null)
            return false;

        if(root.left == null && root.right == null){
            if(root.data == k){
                return true;
            } else {
                return false;
            }
        }

        if(allKSumPaths(root.left, k - root.data) == true)
            return true;

        if(allKSumPaths(root.right, k - root.data) == true)
            return true;

        return false;
    }
}
