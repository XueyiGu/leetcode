public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if(num == 0){
            result[0] = 0;
            return result;
        }
        
        result[1] = 1;
        if(num == 1)
        {
            return result;
        }
    
        for(int i = 1; Math.pow(2, i) <= num; i++)
        {
            for(int j = (int)Math.pow(2, i); j < Math.pow(2, i + 1) && j <= num; j++)
            {
                result[j] = result[j - (int)Math.pow(2, i)] + 1;
            }
        }
        return result;
    }
}