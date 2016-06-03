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
    
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode last = null;
        while(!stack.empty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.peek().right != null && stack.peek().right != last){
                    root = stack.peek().right;
                }else{
                    last = stack.pop();
                    result.add(last.val);
                }
            }
        }
        return result;
    }
}