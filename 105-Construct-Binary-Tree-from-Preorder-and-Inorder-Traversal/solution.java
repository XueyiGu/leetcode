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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || preorder.length == 0){
            return null;
        }
        
        return construct(preorder, 0, preorder.length - 1, 
                            inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int start = inStart;
        while(start < preorder.length && inorder[start] != preorder[preStart]){
            start++;
        }
        int leftLen = start - inStart;
        root.left = construct(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inStart + leftLen - 1);
        root.right = construct(preorder, preStart + leftLen + 1, preEnd, inorder, start + 1, inEnd);
        return root;
    }
}