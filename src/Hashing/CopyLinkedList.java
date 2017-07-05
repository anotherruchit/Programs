package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dharabavishi on 6/28/17.
 * https://www.interviewbit.com/problems/copy-list/
 */
public class CopyLinkedList {
    private HashMap<Node, Node> hashMap;

    public static void main(String args[]){
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        head.random = n3;
        n1.random = n4;
        n2.random = n1;
        n3.random = n3;
        n4.random = n2;

        CopyLinkedList linkedList = new CopyLinkedList();
        Node newHead = linkedList.copyRandomList(head);

        System.out.println("random pointer -> " + newHead.random.x);


    }

    public Node copyRandomList(Node head){

        if (head == null)
            return null;

        Node newHead, node, newNode;
        hashMap = new HashMap<>();

        node = head;
        newHead = null;

        while(node != null){
            newNode = new Node(node.x);

            if(newHead == null){
                newHead = newNode;
            }

            hashMap.put(node, newNode);
            node = node.next;
        }

        for(Map.Entry<Node, Node> entry : hashMap.entrySet()){
            node = entry.getKey();
            newNode = entry.getValue();

            if(node.next != null){
                newNode.next = hashMap.get(node.next);
            }

            if(node.random != null){
                newNode.random = hashMap.get(node.random);
            }
        }

        return newHead;

    }
}

class Node{
    Node next, random;
    int x;

    public Node(int x){
        this.x = x;
    }
}