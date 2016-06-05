public class Solution {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0){
            return result;
        }
        dfs(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int n, int k, int i, List<Integer> visited, List<List<Integer>> result){
        if(visited.size() == k){
            result.add(new ArrayList<Integer>(visited));
            return;
        }
        
        for(; i <= n; i++){
            visited.add(i);
            dfs(n, k, i + 1, visited, result);
            visited.remove(visited.size() - 1);
        }
    }
}