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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        q.add(root);
        int current = 1;
        int next = 0;
        while(!q.isEmpty()){
            TreeNode first = q.poll();
            level.add(first.val);
            if(first.left != null){
                q.add(first.left);
                next++;
            }
            if(first.right != null){
                q.add(first.right);
                next++;
            }
    
            current--;
            if(current == 0){
                result.add(level);
                level = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}