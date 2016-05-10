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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        
        boolean leftToRight = true;
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            List<Integer> level = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            if(leftToRight){
                for(int i = queue.size() - 1; i > -1; i--){
                    TreeNode node = queue.get(i);
                    level.add(node.val);
                    if(node.left != null){
                        next.add(node.left);
                    }
                    if(node.right != null){
                        next.add(node.right);
                    }
                }
                leftToRight = false;
            }else{
                for(int i = queue.size() - 1; i > -1; i--){
                    TreeNode node = queue.get(i);
                    level.add(node.val);
                    if(node.right != null){
                        next.add(node.right);
                    }
                    if(node.left != null){
                        next.add(node.left);
                    }
                }
                leftToRight = true;
            }
            result.add(level);
            queue = next;
        }
        return result;
    }
    
}