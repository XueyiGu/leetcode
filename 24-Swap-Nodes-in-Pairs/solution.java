/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode p = head.next;
        ListNode temp = p.next;
        p.next = head;
        head.next = swapPairs(temp);
        return p;
    }
}