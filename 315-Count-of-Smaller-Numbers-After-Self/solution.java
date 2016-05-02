public class Solution {
    class TreeNode{
        int value;
        int size;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value, int size){
            this.value = value;
            this.size = size;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int n = nums.length;
        TreeNode root = new TreeNode(nums[n - 1], 1);
        result.add(0, 0);
        for(int i = n - 2; i > -1; i--){
            result.add(0, getSmaller(root, nums[i]));
        }
        return result;
    }
    
    private int getSmaller(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value, 1);
            return 0;
        }
        
        if(value > root.value){
            int left_size = root.size;
            if(root.right == null){
                root.right = new TreeNode(value, 1);
                return left_size;
            }else{
                return left_size + getSmaller(root.right, value);
            }
        }else{
            root.size ++;
            if(root.left == null){
                root.left = new TreeNode(value, 1);
                return 0;
            }else{
                return getSmaller(root.left, value);
            }
        }
    }
    
    
}