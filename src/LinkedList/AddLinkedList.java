package LinkedList;

///**
// * Created by dharabavishi on 6/19/17.
// */
//
//
class NewLinkedList{
//    public Node head;
//    public int listCount;
//
//    class Node{
//        int value;
//        Node next;
//        Node(int data){
//            this.value = data;
//            next = null;
//        }
//    }
//
//    public void addNode(int data){
//        Node current = head;
//        Node end = new Node(data);
//
//        while(current.next != null){
//            current = current.next;
//        }
//
//        current.next = end;
//        System.out.println(data+" appended to tail!");
//    }
//
//    public void show(){
//        Node current = head;
//        while(current.next!=null){
//            System.out.print(current.value+" -> ");
//            current = current.next;
//        }
//        System.out.println(current.value);
//    }
//}
//public class AddLinkedList {
//
//    static int getValue(LinkedList.NewLinkedList node) {
//        int value = node.;
//        while (node.next != null) {
//            node = node.next;
//            value = value * 10 + node.value;
//        }
//        return value;
//    }
//
//    static LinkedList.NewLinkedList getSum(LinkedList.NewLinkedList a, LinkedList.NewLinkedList b) {
//        LinkedList.NewLinkedList answer = new LinkedList.NewLinkedList(0);
//        LinkedList.NewLinkedList ans = answer;
//        int aval = getValue(a);
//        int bval = getValue(b);
//        int result = aval + bval;
//        while (result > 0) {
//            int len = (int) Math.pow((double) 10,
//                    (double) String.valueOf(result).length() - 1);
//            int val = result / len;
//            ans.next = new AddLinkedList(val);
//            ans = ans.next;
//            result = result - val*len;
//        }
//        return answer.next;
//    }
//
    public static void main(String args[]){
//        LinkedList.NewLinkedList list1 = new LinkedList.NewLinkedList();
//        list1.addNode(7);
//        list1.addNode(2);
//        list1.addNode(4);
//        list1.addNode(3);
//        LinkedList.NewLinkedList list2 = new LinkedList.NewLinkedList();
//        list2.addNode(5);
//        list2.addNode(6);
//        list2.addNode(4);
        for(int i = 0; i < 10; ++i){
            System.out.println("Value is : " +i);
        }
    }
}
//
