/*https://www.codingninjas.com/codestudio/problems/920454?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
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
 };

 *****************************************************************/

public class Solution {
	// TC O(2n) | SC O(1)
    public static Node rotate(Node head, int k) {
        // Write your code here.
        Node first = head;
        Node second = head;
        int idx = 1;
        int count = 0;
        while(first != null){
            first = first.next;
            count++;
        }
        k = k % count;
        first = head;
        while(idx < count-k){
            second = second.next;
            first = first.next;
            idx++;
        }
        while(second.next != null){
            second = second.next;
        }
        second.next = head;
        Node res = first.next;
        first.next = null;
        return res;
    }
}
