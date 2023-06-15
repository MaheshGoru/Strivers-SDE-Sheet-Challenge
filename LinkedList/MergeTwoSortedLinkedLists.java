/*https://www.codingninjas.com/codestudio/problems/800332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	// TC O(m+n) | SC O(m+n)
	// public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
	// 	// Write your code here.
    //     LinkedListNode<Integer> newList = null;
    //     LinkedListNode<Integer> newHead = null;
    //     while(first != null && second != null){
    //         if(first.data < second.data){
    //             if(newHead == null){
    //                 newHead = first;
    //                 newList = first;
    //             }
    //             else{
    //                 newList.next = first;
    //                 newList = newList.next;
    //             }
    //             first = first.next;
    //         }else{
    //             if(newHead == null){
    //                 newHead = second;
    //                 newList = second;
    //             }
    //             else{
    //                 newList.next = second;
    //                 newList = newList.next;
    //             }
    //             second = second.next;
    //         }
    //     }
    //     while(first != null){
    //         if(newHead == null){
    //             newHead = first;
    //             newList = first;
    //         }
    //         else{
    //             newList.next = first;
    //             newList = newList.next;
    //         }
    //         first = first.next;
    //     }
    //     while(second != null){
    //         if(newHead == null){
    //             newHead = second;
    //             newList = second;
    //         }
    //         else{
    //             newList.next = second;
    //             newList = newList.next;
    //         }
    //         second = second.next;
    //     }
    //     return newHead;
	// }


	// TC O(m+n) | SC O(1)
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> l1,
    LinkedListNode<Integer> l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data > l2.data) {
            LinkedListNode<Integer> temp = l1;
            l1 = l2;
            l2 = temp;
        }
        LinkedListNode<Integer> res = l1;
        while (l1 != null && l2 != null) {
            LinkedListNode<Integer> temp = null;
            while (l1 != null && l1.data <= l2.data) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            LinkedListNode<Integer> swap = l1;
            l1 = l2;
            l2 = swap;
        }
        return res;
    }
}

