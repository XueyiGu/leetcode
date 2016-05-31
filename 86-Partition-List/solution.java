/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        
        ListNode tail1 = first;
        ListNode tail2 = second;
        
        while(head != null){
            if(head.val < x){
                tail1.next = head;
                head = head.next;
                tail1 = tail1.next;
                tail1.next = null;
            }else{
                tail2.next = head;
                head = head.next;
                tail2 = tail2.next;
                tail2.next = null;
            }
        }
        tail1.next = second.next;
        return first.next;
    }
}