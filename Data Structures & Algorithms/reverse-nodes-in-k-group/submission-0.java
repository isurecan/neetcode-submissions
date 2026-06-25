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
        if(head==null) return null;
        ListNode prev=null, curr=head, next=null;
        int c=k;
        while(curr!=null && c>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            c--;
        }

        if(curr==null && c>0) //less than k nodes
        {
            //we had reversed this also, so we reverse it again to undo
            //since we reversed before so now prev has the head of this segment
            curr=prev;
            prev=null; next=null;
            while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        }
        //1->2->3->4->5->6->7->8
        //3->2->1  4->5->6->7->8
        //head is at 1, prev at 3, next at 4, curr=4
        //now we need to connect
        //we need to create 3->2->1->6->5->4...
        //ie head.next needs to connect with the reversed list

        if(c>0){
            return prev;
        }
        else{
        head.next=reverseKGroup(curr, k);
        }
        
        return prev;
    }


}
