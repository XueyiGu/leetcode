/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null || k == 1){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = dummy;
        int m = 0;
        while(current != null){
            current = current.next;
            m++;
            if(current != null && m == k){
                ListNode next = current.next;
                current.next = null;
                ListNode p = pre.next;
                pre.next = reverseNodes(p);
                
                pre = p;
                m = 1;
                current = next;
                pre.next = current;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseNodes(ListNode head){
        ListNode p = head;
        ListNode q = p.next;
        while(q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head.next = null;
        return p;
    }
}