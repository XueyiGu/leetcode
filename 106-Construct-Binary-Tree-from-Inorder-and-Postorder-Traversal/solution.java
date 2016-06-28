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
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int start = inStart;
        while(start < inorder.length && inorder[start] != postorder[postEnd]){
            start++;
        }
        int leftLen = start - inStart;
        root.left = construct(inorder, inStart, inStart + leftLen - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = construct(inorder, start + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}