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
    public boolean isValidBST(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        if(node.val > min && node.val < max){
            return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        }else{
            return false;
        }
    }
}