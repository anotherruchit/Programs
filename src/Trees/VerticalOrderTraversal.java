package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruchitmehta.
 * https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
 */
public class VerticalOrderTraversal {

    public static void main(String args[]){
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
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

        List<List<Integer>> result = tree.verticalTraversalOrder(root);
        for(List<Integer> list: result){
            System.out.println(list.toString());
        }

    }

    public List<List<Integer>> verticalTraversalOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        // Level and List
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int maxLevel = 0;
        int minLevel = 0;

        while(! queue.isEmpty()){
            TreeNode curr = queue.poll();
            int lev = level.poll();

            // tracking min and max levels
            minLevel = Math.min(minLevel, lev);
            maxLevel = Math.max(maxLevel, lev);

            if(map.containsKey(lev)){
                map.get(lev).add(curr.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.data);
                map.put(lev, list);
            }

            if(curr.left != null){
                queue.offer(curr.left);
                level.offer(lev - 1);
            }

            if(curr.right != null){
                queue.offer(curr.right);
                level.offer(lev + 1);
            }
        }

        for(int i = minLevel; i <= maxLevel; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }

        return result;
    }
}
