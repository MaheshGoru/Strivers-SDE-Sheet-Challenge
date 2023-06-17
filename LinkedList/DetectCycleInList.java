/*https://www.codingninjas.com/codestudio/problems/628974?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

import java.util.*;
public class Solution {

	// TC O(n) | SC O(n)
    // public static boolean detectCycle(Node head) {
    //     //Your code goes here
    //     Set<Node> set = new HashSet<Node>();
    //     while(head != null){
    //         if(set.contains(head)) return true;
    //         set.add(head);
    //         head = head.next;
    //     }
    //     return false;
    // }

	// slow fast pointer approach | TC O(n) | SC O(1)
    public static boolean detectCycle(Node head){
        if(head == null) return false;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
