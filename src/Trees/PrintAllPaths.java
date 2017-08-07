package Trees;

import java.util.ArrayList;

/**
 * Created by ruchitmehta on 7/30/17.
 */
public class PrintAllPaths {
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

        ArrayList<Integer> paths = new ArrayList<>();

        printAllPaths(root, new int[1000], 0);
    }

    // recursive approach
    public static void printAllPaths(TreeNode root, int[] paths, int pathLength){
        if(root == null)
            return;

         /* append this node to the path array */
         paths[pathLength] = root.data;
         pathLength++;

        /* it's a leaf, so print the path that led to here  */
        if(root.left == null && root.right == null){
            // print all paths in the array list
            printPath(paths, pathLength);
        } else {
            /* otherwise try both subtrees */
            printAllPaths(root.left, paths, pathLength);
            printAllPaths(root.right, paths, pathLength);
        }
    }

    public static void printPath(int[] paths, int length){
        for(int i = 0; i < length; i++){
            System.out.print(paths[i] + "  ");
        }
        System.out.println(" ");
    }
}
