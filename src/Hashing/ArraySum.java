package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dharabavishi on 6/27/17.
 * https://www.interviewbit.com/problems/equal/
 */
public class ArraySum {

    class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> a =  new ArrayList<Integer>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArraySum e = new ArraySum();
        result = e.equal(a);
        System.out.println(result);
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A){

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Node>> hashMap = new HashMap<>();
        int n, sum;

        Node curNode;
        ArrayList<Node> nodes;
        n = A.size();

        if(A == null || A.size() < 4)
            return  result;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                sum = A.get(i) + A.get(j);
                curNode = new Node(i,j);

                if(hashMap.containsKey(sum)){
                    nodes = hashMap.get(sum);
                } else {
                    nodes = new ArrayList<>();
                }

                nodes.add(curNode);
                hashMap.put(sum, nodes);
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = i+1 ; j < n; j++){
                sum = A.get(i) + A.get(j);
                curNode = new Node(i, j);

                if (hashMap.containsKey(sum)) {
                    nodes = hashMap.get(sum);

                    for (Node node : nodes) {
                        if (overlaps(curNode, node))
                            continue;
                        result.add(curNode.x);
                        result.add(curNode.y);
                        result.add(node.x);
                        result.add(node.y);
                        return result;
                    }
                }
            }
        }
        return  result;
    }

    public boolean overlaps(Node n1, Node n2) {

        if (n1.x == n2.x || n1.x == n2.y || n1.y == n2.x || n1.y == n2.y)
            return true;

        return false;
    }
}
