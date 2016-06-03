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
    
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode top = stack.pop();
            result.add(top.val);
            if(top.right != null){
                stack.push(top.right);
            }
            
            if(top.left != null){
                stack.push(top.left);
            }
        }
        return result;
    }
    
}