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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null|| lists.length==0){
            return null;
        }
        return mergeKListHelper(lists, 0, lists.length-1);
    }

    private ListNode mergeKListHelper(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        if(start+1==end){
            return merge2Lists(lists[start],lists[end]);
        }
        int mid=start+(end-start)/2;
        ListNode left=mergeKListHelper(lists, start, mid);
        ListNode right=mergeKListHelper(lists, mid+1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode a, ListNode b){
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode curr=head;

        while(a!=null && b!=null){
            if(a.val<b.val){
                curr.next=a;
                a=a.next;
            }
            else{
                curr.next=b;
                b=b.next;
            }
            curr=curr.next;
        }

        curr.next=(a==null)?b:a;
        return head.next;
    }
    
}
