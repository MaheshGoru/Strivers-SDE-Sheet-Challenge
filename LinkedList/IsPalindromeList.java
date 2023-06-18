/*https://www.codingninjas.com/codestudio/problems/799352?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	// TC O(2n) | SC O(n)
	// public static boolean isPalindrome(LinkedListNode<Integer> head) {
	// 	// Write your code here!
	// 	ArrayList<Integer> list = new ArrayList<>();
	// 	LinkedListNode<Integer> temp = head;
	// 	while(temp != null){
	// 		list.add(temp.data);
	// 		temp = temp.next;
	// 	}

	// 	int start = 0;
	// 	int end = list.size()-1;
	// 	while(start < end){
	// 		if((int)list.get(start++) != (int)list.get(end--)) return false;
	// 	}
	// 	return true;
	// }

	// Reverse Half List | TC O(n) | SC O(1)
	public static boolean isPalindrome(LinkedListNode<Integer> head){
		if(head == null || head.next == null) return true;
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode<Integer> mid = slow;
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = mid.next;
		while(curr != null){
			LinkedListNode<Integer> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		slow.next = prev;
		fast = prev;
		slow = head;
		while(fast != null){
			if((int)slow.data != (int)fast.data) return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
}
