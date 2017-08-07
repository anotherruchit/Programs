//package Trees;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
///**
// * Created by ruchitmehta on 7/27/17.
// */
//public class ValidBST {
//    public static void main(String args[]){
//        TreeNode root = new TreeNode(10);
////        isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        isValidBST(root);
//    }
//
//    public static boolean isValidBST(TreeNode root){
//        if(root == null)
//            return false;
//
//        Stack<TreeNode> stack = new Stack<>();
//        ArrayList<Integer> inOrder = new ArrayList<>();
//
//        TreeNode curr = root;
//        addNodesToStack(curr, stack);
//
//        while(!stack.isEmpty()){
//
//        }
//    }
//
//    public static void addNodesToStack(TreeNode curr, Stack<TreeNode> stack){
//        while(curr != null){
//            stack.push(curr);
//            curr = curr.left;
//        }
//    }
//
////    public static boolean isValidBST(TreeNode root, int min, int max){
////
////
////    }
//
//}
