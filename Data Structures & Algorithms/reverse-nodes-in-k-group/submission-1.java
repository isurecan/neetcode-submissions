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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode count=head;

        for(int i=0; i<k; i++){
            if(count==null) return head;
            else count=count.next;
        }

        ListNode prev=null, curr=head, next=null;
        while(curr!=count){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=reverseKGroup(count, k);
        return prev;
    }
}
