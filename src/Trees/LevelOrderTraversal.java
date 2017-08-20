package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruchitmehta
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
 * TODO: Use the below solution to implement -
 * TODO: http://javabypatel.blogspot.in/2015/08/connect-nodes-at-same-level-in-binary-tree-using-constant-extra-space.html
 *
 */
public class LevelOrderTraversal {
    public static void main(String args[]){
        LevelOrderTraversal tree = new LevelOrderTraversal();
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

        ArrayList<ArrayList<Integer>> result = tree.levelOrder(root);
        System.out.println("Level Order List is : ");
        for(List<Integer> list: result){
            System.out.println(list.toString());
        }

        // Reverse Level Order Traversal
        result = tree.reverseLevelOrderTraversal(result);
        System.out.println("Reverse Level Order List is : ");
        for(List<Integer> list: result){
            System.out.println(list.toString());
        }

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nodeValues = new ArrayList<>();
        TreeNode curr;

        if(root == null){
            return result;
        }

        queue.add(root);

        while(! queue.isEmpty()){
            curr = queue.pop();

            if(curr.left != null){
                next.add(curr.left);
            }
            if(curr.right != null){
                next.add(curr.right);
            }

            nodeValues.add(curr.data);
            if(queue.isEmpty()){
                queue = next;
                next = new LinkedList<>();
                result.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> reverseLevelOrderTraversal(ArrayList<ArrayList<Integer>> result){
        ArrayList<ArrayList<Integer>> reversedResult = new ArrayList<ArrayList<Integer>>();
        for(int i = result.size()-1; i > 0; i--){
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
}
