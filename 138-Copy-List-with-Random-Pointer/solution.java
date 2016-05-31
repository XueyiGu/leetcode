/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        if(head == null){
            return null;
        }
        //first, copy next
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cur1 = head;
        RandomListNode cur2 = newHead;
        while(cur1.next != null){
            cur1 = cur1.next;
            RandomListNode node = new RandomListNode(cur1.label);
            cur2.next = node;
            cur2 = cur2.next;
        }
        //second, merge the orginal and new lists together
        cur1 = head;
        cur2 = newHead;
        while(cur1 != null){
            RandomListNode temp1 = cur1.next;
            RandomListNode temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
        
        //thrid, copy the random
        cur1 = head;
        while(cur1 != null){
            if(cur1.random != null){
                cur1.next.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
        }
        //fourth, split the merged list into two lists
        cur1 = head;
        cur2 = newHead;
        while(cur1.next != null && cur2.next != null){
            cur1.next = cur1.next.next;
            cur2.next = cur2.next.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = null;
        return newHead;
    }
}