/*https://www.codingninjas.com/codestudio/problems/799912?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
	// TC O(2N) | SC O(1)
    // public static Node removeKthNode(Node head, int K)
    // {
    //     // Write your code here.
    //     Node first = head;
    //     Node second = head;
    //     int i = 1;
    //     while(i <= K){
    //         second = second.next;
    //         i++;
    //     }
    //     if(second == null) return head.next;
    //     while(second != null){
    //         first = first.next;
    //         second = second.next;
    //     }
    //     second = head;
    //     while(second.next != first){
    //         second = second.next;
    //     }
    //     second.next = second.next.next;
    //     return head;
    // }

	// TC O(n) | SC O(1)
    public static Node removeKthNode(Node head, int K){
        Node start = new Node();
        start.next = head;
        Node first = start;
        Node second = start;
        for(int i=0;i<K;i++){
            second = second.next;
        }
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return start.next;
    }
}
