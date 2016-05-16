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
    
    public void flatten(TreeNode root) 
    {
        if(root == null){
            return;
        }
        
        if(root.left == null){
            flatten(root.right);
        }else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            //find the right-most node of the current right subtree
            TreeNode current = root.right;
            while(current.right != null){
                current = current.right;
            }
            current.right = temp;
            flatten(root.right);
        }
    }
}