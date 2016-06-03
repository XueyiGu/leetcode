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
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        List<Integer> level = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            level.add(first.val);
            if(first.left != null){
                queue.add(first.left);
                next++;
            }
            if(first.right != null){
                queue.add(first.right);
                next++;
            }
            current--;
            if(current == 0){
                result.add(0, level);
                level = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}