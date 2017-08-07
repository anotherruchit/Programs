package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruchitmehta on 7/31/17.
 */
public class DiagonalElementsOfBT {
    public static void main(String args[]){
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

        diagonalElements(root);
    }

    static List<List<Integer>> diagonalElements(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                // diagonal over, so moving to next diagonal
                queue.offer(null);
                curr = queue.poll();
                // everything is processed
                if(curr == null){
                    break;
                }
            }

            while(curr != null){
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                curr = curr.right;
            }
            System.out.println("");
        }

        return result;
    }
}
