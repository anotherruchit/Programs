package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruchitmehta.
 * https://www.youtube.com/watch?v=eBdKNoW3VJg
 */
public class LeftSideViewBT {
    public static void main(String args[]){
        LeftSideViewBT tree = new LeftSideViewBT();
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
        List<Integer> result = tree.leftSideView(root);
        System.out.println(result.toString());

        // Recursive Approach
        List<Integer> list = new ArrayList<>();
        tree.leftView(root, list, 0);
        System.out.println(list.toString());

    }

    // Queue Approach
    public List<Integer> leftSideView(TreeNode root){

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
                if(top.left != null){
//                    System.out.println("Adding " + top.right.data);
                    queue.add(top.left);
                }
                //add left
                if(top.right != null){
//                    System.out.println("Adding " + top.left.data);
                    queue.add(top.right);
                }

            }
        }

        return result;
    }

    // Recursive Approach
    public void leftView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);

    }
}
