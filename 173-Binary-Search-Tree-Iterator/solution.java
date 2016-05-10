/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack stack = new Stack();
    public BSTIterator(TreeNode node)
    {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    public boolean hasNext()
    {
        return (!stack.isEmpty());
    }
    
    public int next()
    {
        TreeNode top = (TreeNode)stack.pop();
        int result = top.val;
        TreeNode node = top.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */