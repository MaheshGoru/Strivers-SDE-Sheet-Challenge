/*https://www.codingninjas.com/codestudio/problems/873376?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	// TC O(n) | SC O(n)
	// public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
	// 	// Write your code here.
	// 	Map<LinkedListNode,LinkedListNode> map = new HashMap<>();
	// 	LinkedListNode temp = head;
	// 	while(temp != null){
	// 		LinkedListNode node = new LinkedListNode(temp.data);
	// 		map.put(temp, node);
	// 		temp = temp.next;
	// 	}
	// 	LinkedListNode dummy = new LinkedListNode(0);
	// 	LinkedListNode res = dummy;
	// 	temp = head;
	// 	while(temp != null){
	// 		LinkedListNode node = map.get(temp);
	// 		node.next = map.get(temp.next);
	// 		node.random = map.get(temp.random);
	// 		dummy.next = node;
	// 		dummy = dummy.next;
	// 		temp = temp.next;
	// 	}
	// 	return res.next;
	// }

	// TC O(n) | SC O(1)
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		LinkedListNode itr = head;
		while(itr != null){
			LinkedListNode node = new LinkedListNode(itr.data);
			node.next = itr.next;
			itr.next = node;
			itr = itr.next.next;
		}

		itr = head;
		while(itr != null){
			if(itr.random != null){
				itr.next.random = itr.random.next;
			}
			itr = itr.next.next;
		}

		LinkedListNode dummy = new LinkedListNode(0);
		itr = head;
		LinkedListNode temp = dummy;
		LinkedListNode fast;
		while(itr != null){
			fast = itr.next.next;
			temp.next = itr.next;
			itr.next = fast;
			temp = temp.next;
			itr = itr.next;
		}
		return dummy.next;
	}
}

