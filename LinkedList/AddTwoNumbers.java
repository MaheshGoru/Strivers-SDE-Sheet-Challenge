/*https://leetcode.com/problems/add-two-numbers/submissions/973360123/*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	// TC O(max(m,n)) | SC O(1)
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int carry = 0;
       ListNode ll = new ListNode(-1);
       ListNode temp = ll;

       while(head1 != null && head2 != null){
           int val = head1.val + head2.val + carry;
           carry = val/10;
           val = val%10;
           ListNode n = new ListNode(val);
           temp.next = n;
           temp = n;

           head1 = head1.next;
           head2 = head2.next;
       }

       while(head1 != null){
           int val = head1.val + carry;
           carry = val/10;
           val = val%10;
           ListNode n = new ListNode(val);
           temp.next = n;
           temp = n;

           head1 = head1.next;
       }

       while(head2 != null){
           int val = head2.val + carry;
           carry = val/10;
           val = val%10;
           ListNode n = new ListNode(val);
           temp.next = n;
           temp = n;

           head2 = head2.next;
       }

       if(carry > 0){
          ListNode n = new ListNode(carry);
           temp.next = n;
           temp = n;
       }

       return ll.next;
    }
}
