/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = current.next;
            
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = current.next;
            
            carry = sum / 10;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int sum = l2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = current.next;
            
            carry = sum / 10;
            l2 = l2.next;
        }
        
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            current.next = newNode;
        }
        return fakeHead.next;
    }
}