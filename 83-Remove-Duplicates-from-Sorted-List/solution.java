/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode tail = head;
        ListNode current = head.next;
        head.next = null;
        while(current != null){
            if(current.val != tail.val){
                tail.next = current;
                tail = tail.next;
                
                current = current.next;
                tail.next = null;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}