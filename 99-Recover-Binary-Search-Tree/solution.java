/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root){
        inorder(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        inorder(node.left);
        if(pre == null){
            pre = node;
        }else{
            if(pre.val > node.val){
                if(first == null){
                    first = pre;
                }
                second = node;
            }
            pre = node;
        }
        inorder(node.right);
    }
}