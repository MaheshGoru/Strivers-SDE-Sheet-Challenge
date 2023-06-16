/*https://www.codingninjas.com/codestudio/problems/1105578?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	// TC O(1) | SC O(1)
	public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        node.data = node.next.data;
        node.next = node.next.next;
	}
}
