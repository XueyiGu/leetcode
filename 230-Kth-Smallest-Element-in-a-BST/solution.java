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
    public int kthSmallest(TreeNode root, int k) 
    {
        int left_size = size(root.left);
        int root_rank = left_size + 1;
        if(root_rank == k){
            return root.val;
        }else if(root_rank > k){
            return kthSmallest(root.left, k);
        }else{
            return kthSmallest(root.right, k - root_rank);
        }
    }
    
    private int size(TreeNode node){
        if(node == null){
            return 0;
        }
        
        return size(node.left) + 1 + size(node.right);
    }
    
}