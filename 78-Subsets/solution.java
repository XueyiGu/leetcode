public class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int k = 1; k <= nums.length; k++){
            dfs(nums, k, 0, new ArrayList<Integer>(), result);
        }
        return result;
    }
    
    private void dfs(int[] nums, int k, int i, List<Integer> visited, List<List<Integer>> result){
        if(visited.size() == k){
            List<Integer> item = new ArrayList<Integer>();
            for(int j = 0; j < visited.size(); j++){
                item.add(nums[visited.get(j)]);
            }
            result.add(item);
            return;
        }
        for(int j = i; j < nums.length; j++){
            visited.add(j);
            dfs(nums, k, j + 1, visited, result);
            visited.remove(visited.size() - 1);
        }
    }
}