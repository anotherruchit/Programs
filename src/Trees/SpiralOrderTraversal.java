package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ruchitmehta.
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
 */
public class SpiralOrderTraversal {
    public static void main(String args[]){
        SpiralOrderTraversal tree = new SpiralOrderTraversal();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(6);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(3);
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;

        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(9);
        n5.left = n6;
        n5.right = n7;

        ArrayList<ArrayList<Integer>> result = tree.spriralOrderTraversal(root);
        System.out.println("Level Order List is : ");
        for(List<Integer> list: result){
            System.out.println(list.toString());
        }
    }

    public ArrayList<ArrayList<Integer>> spriralOrderTraversal(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        boolean order = true;

        while(!queue.isEmpty()){
            ArrayList<Integer> temp =  new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(order){
                    temp.add(curr.data);
                } else{
                    temp.add(0, curr.data);
                }

                if(curr.left != null) queue.add(curr.left);
                if(curr.right!= null) queue.add(curr.right);
            }

            result.add(temp);
            size = queue.size();
            if(order)
                order = false;
            else
                order = true;

        }
        return result;
    }
}
