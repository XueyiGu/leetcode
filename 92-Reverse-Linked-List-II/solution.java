/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(m == n){
            return head;
        }
        //find position m
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int count = 0;
        ListNode current = dummy;
        
        while(count < m - 1){
            current = current.next;
            count++;
        }
        ListNode header = current;
        
        count++;
        current = current.next;
        ListNode secondHead = current;
        ListNode next = current.next;
        count++;
        while(count <= n){
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
            count++;
        }
        
        secondHead.next = next;
        header.next = current;
        return dummy.next;
        
    }
}