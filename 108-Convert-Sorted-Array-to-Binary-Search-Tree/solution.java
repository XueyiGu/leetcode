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
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        return makeTrees(nums, 0, nums.length - 1);
    }
    
    private TreeNode makeTrees(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTrees(nums, start, mid - 1);
        node.right = makeTrees(nums, mid + 1, end);
        return node;
    }
}