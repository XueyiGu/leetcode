public class Solution {
    public List<Integer> grayCode(int n) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(n < 0){
            return result;
        }
        
        result.add(0);
        for(int i = 1; i <= n; i++){
            List<Integer> next = new ArrayList<Integer>(result);
            for(int j = result.size() - 1; j > -1 ; j--){
                next.add(result.get(j) + (int)Math.pow(2, i - 1));
            }
            result = next;
        }
        return result;
    }
}