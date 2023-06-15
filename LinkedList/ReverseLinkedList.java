/*https://www.codingninjas.com/codestudio/problems/799897?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
	// TC O(n) | SC O(1)
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		while(curr != null){
			LinkedListNode<Integer> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
    }
}
