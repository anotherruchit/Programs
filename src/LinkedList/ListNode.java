package LinkedList;

/**
 * Created by dharabavishi on 6/21/17.
 */
public class ListNode{
    public ListNode next;
    public String data;
    public int intData;

    ListNode(String data){
        this.data = data;
        this.next = null;
    }

    public ListNode(int data){
        this.intData = data;
        this.next = null;
    }

    public String toString(){
        return this.data;
    }
}