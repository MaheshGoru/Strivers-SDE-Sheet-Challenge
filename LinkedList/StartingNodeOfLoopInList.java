/*https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems/*/
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
    public static Node firstNode(Node head){
        Set<Node> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
	// TC O(n) | SC O(1)
    // public static Node firstNode(Node head) {
    //     // Write your code here.
    //     if(head == null || head.next == null) return null;
    //     Node slow = head;
    //     Node fast = head;
    //     while(fast != null && fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //         if(slow == fast) break;
    //     }
    //     fast = head;
    //     while(slow != null && slow != fast){
    //         slow = slow.next;
    //         fast = fast.next;
    //     }
    //     return slow;
    // }
}
