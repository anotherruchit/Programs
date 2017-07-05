package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruchitmehta.
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/
 * https://www.youtube.com/watch?v=eBdKNoW3VJg
 *    1            <---
    /   \
   2     3         <---
    \
     5             <---
    Solution: [1, 3, 5].
 */
public class RightSideViewBT {
    public static void main(String args[]){
        RightSideViewBT tree = new RightSideViewBT();
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

        TreeNode n6 = new TreeNode(8);
        n4.right = n6;

        // Queue Approach
        List<Integer> result = tree.rightSideView(root);
        System.out.println(result.toString());

        // Recursive Approach
        List<Integer> list = new ArrayList<>();
        tree.rightView(root, list, 0);
        System.out.println(list.toString());

    }

    // Queue Approach
    public List<Integer> rightSideView(TreeNode root){

        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
//                    System.out.println("Printing " + top.data);
                    result.add(top.data);
                }
                //add right first
                if(top.right != null){
//                    System.out.println("Adding " + top.right.data);
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
//                    System.out.println("Adding " + top.left.data);
                    queue.add(top.left);
                }

            }
        }

        return result;
    }

    // Recursive Approach
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
