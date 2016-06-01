/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        //find the middle point of list
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        //reverse the second half
        head2 = reverse(head2);
        //merge two lists
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null || head2 != null){
            if(head != null){
                cur.next = head;
                head = head.next;
                cur = cur.next;
            }
            if(head2 != null){
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        // return fummy.next;
    }
    private ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode p = node;
        ListNode q = node.next;
        while(q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        node.next = null;
        return p;
    }
}