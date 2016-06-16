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
        while(root != null){
            TreeLinkNode next = null;
            TreeLinkNode pre = null;
            for(; root != null; root = root.next){
                if(next == null){
                    next = root.left != null ? root.left : root.right;
                }
                
                if(root.left != null){
                    if(pre != null){
                        pre.next = root.left;
                    }
                    pre = root.left;
                }
                
                if(root.right != null){
                    if(pre != null){
                        pre.next = root.right;
                    }
                    pre = root.right;
                }
            }
            root = next;
        }
    }
}