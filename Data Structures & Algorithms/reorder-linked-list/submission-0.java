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
    public void reorderList(ListNode head) {
        //base case
        if(head==null || head.next==null)
        return ;

        //find mid
        ListNode p1=head;
        ListNode p2=head;

        while(p2.next!=null && p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //reverse the escond half

        ListNode curr=p1.next;
        p1.next=null;   //split the two lists
        ListNode prev=null;
       while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
       }

        //combine
        ListNode first=head;   // head is the head of first half
        ListNode second=prev;  // prev is the head of reversed second half

        while(second!=null){
        ListNode temp1=first.next;
        ListNode temp2=second.next;

        first.next=second;
        second.next=temp1;

        first=temp1;
        second=temp2;

        }
    }
}
