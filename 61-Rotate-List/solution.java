/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null){
            return head;
        }
        
        int n = 1;
        ListNode current = head;
        while(current.next != null){
            n++;
            current = current.next;
        }
        
        int step = n - (k % n);
        current.next = head;
        while(step > 0){
            current = current.next;
            step--;
        }
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }
}