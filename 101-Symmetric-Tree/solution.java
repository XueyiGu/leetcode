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
    public boolean isSymmetric(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return symmetric(root.left, root.right);
    }
    
    private boolean symmetric(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        
        if(n1 == null && n2 != null || n1 != null && n2 == null){
            return false;
        }
        
        if(n1.val == n2.val){
            return symmetric(n1.left, n2.right) && symmetric(n1.right, n2.left);
        }else{
            return false;
        }
    }
}