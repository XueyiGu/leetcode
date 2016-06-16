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
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int diff = Math.abs(depth(root.left) - depth(root.right));
        if(diff <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }else{
            return false;
        }
    }
    
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }else{
            return Math.max(depth(node.left), depth(node.right)) + 1;
        }
    }
}