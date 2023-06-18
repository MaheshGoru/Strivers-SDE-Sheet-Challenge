/*https://www.codingninjas.com/codestudio/problems/1112655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {
	// TC O(n) | SC O(1) | n is the total nodes
    public static Node flattenLinkedList(Node head) {
        //Write your code here
        if(head == null || head.next == null) return head;
        head.next = flattenLinkedList(head.next);
        head = merge(head, head.next);
        return head;
    }

    private static Node merge(Node first, Node second){
        Node dummy = new Node(0);
        Node res = dummy;
        while(first != null && second != null){
            if(first.data < second.data){
                dummy.child = first;
                first = first.child;
            }else{
                dummy.child = second;
                second = second.child;
            }
            dummy = dummy.child;
        }
        if(first != null) dummy.child = first;
        else dummy.child = second;
        return res.child;
    }
}
