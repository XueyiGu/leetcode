/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root){
        if(root == null || root.left == null && root.right == null){
            return;
        }
        
        TreeLinkNode current = root;
        TreeLinkNode next = current.left;
        while(current != null && next != null){
            current.left.next = current.right;
            if(current.next != null){
                current.right.next = current.next.left;
                current = current.next;
            }else{
                if(next != null){
                    current = next;
                    next = current.left;
                }else{
                    current = current.next;
                }
            }
        }
        
    }
}