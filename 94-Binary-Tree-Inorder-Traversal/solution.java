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
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else if(!stack.empty()){
                TreeNode top = stack.pop();
                result.add(top.val);
                root = top.right;
            }
        }
        return result;
    
    }
}