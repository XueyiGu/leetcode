/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) 
    {
        ListNode fakeHead = new ListNode(0);
        while(head != null){
            //insert the head into current sorted list
            ListNode temp = head;
            head = head.next;
            ListNode current = fakeHead;
            while(current.next != null && current.next.val <= temp.val){
                current = current.next;
            }
            
            ListNode next = current.next;
            current.next = temp;
            temp.next = next;
        }
        return fakeHead.next;
    }
}