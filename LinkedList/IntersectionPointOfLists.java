/*https://www.codingninjas.com/codestudio/problems/630457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
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
	// TC O(m+n) | SC O(max(m,n))
    // public static int findIntersection(Node firstHead, Node secondHead) {
    //     //Write your code here
    //     Set<Node> set = new HashSet<Node>();
    //     while(firstHead != null){
    //         set.add(firstHead);
    //         firstHead = firstHead.next;
    //     }
    //     while(secondHead != null){
    //         if(set.contains(secondHead))
    //             return secondHead.data;
    //         secondHead = secondHead.next;
    //     }
    //     return -1;
    // }

	// TC O(m+n) | SC O(1)
    public static int findIntersection(Node firstHead, Node secondHead){
        int length1 = getLength(firstHead);
        int length2 = getLength(secondHead);
        Node smallNode = null;
        Node maxNode = null;
        if(length1 > length2){
            maxNode = firstHead;
            smallNode = secondHead;
        }else {
            maxNode = secondHead;
            smallNode = firstHead;
        }
        int diff = Math.abs(length1 - length2);
        int idx = 0;
        while(idx < diff){
            maxNode = maxNode.next;
            idx++;
        }
        while(smallNode != maxNode){
            smallNode = smallNode.next;
            maxNode = maxNode.next;
        }
        return smallNode == null ? -1 : smallNode.data;
    }

    private static int getLength(Node node){
        int idx = 0;
        while(node != null){
            idx++;
            node = node.next;
        }
        return idx;
    }
}
