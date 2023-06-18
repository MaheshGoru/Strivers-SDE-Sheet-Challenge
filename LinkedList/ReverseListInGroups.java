/*https://www.codingninjas.com/codestudio/problems/763406?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	// TC O(2n) | SC O(1)
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
		if(head == null || head.next == null) return head;
		Node dummy = new Node(0);
		dummy.next = head;
		Node prev = dummy;
		Node curr = dummy.next;
		Node next = curr.next;
		int count = 0;
		while(curr != null){
			curr = curr.next;
			count++;
		}
		int i = 0;
		curr = prev.next;
		while(count >= 0 && i < b.length){
			int idx = 1;
			if(prev != null && prev.next != null && b[i] > 0){
				curr = prev.next;
				next = curr.next;
				while(idx < b[i] && next != null){
					curr.next = next.next;
					next.next = prev.next;
					prev.next = next;
					next = curr.next;
					idx++;
				}
				prev = curr;
			}
			count -= b[i];
			i++;
		}
		return dummy.next;
	}
}
