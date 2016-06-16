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
        
        if(root.left != null){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            //find the most right son
            TreeNode current = root.right;
            while(current.right != null){
                current = current.right;
            }
            current.right = right;
        }
        flatten(root.right);
    }
}