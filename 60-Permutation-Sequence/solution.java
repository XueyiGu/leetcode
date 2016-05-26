public class Solution {
    public String getPermutation(int n, int k) 
    {
        
        if(n == 1)
        {
            return "1";
        }
        
        // there are n -1 permutations started with i, 1 <= i <= n
        // so, 
        
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
        {
            nums.add(i + 1);
        }
        
        int fac = 1;
        for(int i = 0; i < n; i++)
        {
            fac = fac * (i + 1);
        }
        
        k--;
        
        String result = "";
        
        for(int i = 0; i < n; i++)
        {
            fac = fac / (n - i);
            int index = k / fac;
            result = result + nums.get(index);
            k = k % fac;
            nums.remove(index);
        }
        
        return result.toString();
    
    }
}