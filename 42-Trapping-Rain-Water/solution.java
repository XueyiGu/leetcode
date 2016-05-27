public class Solution {
    public int trap(int[] height) 
    {
        
        if(height == null || height.length < 3)
        {
            return 0;
        }
        
        int n = height.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        //from left to right;
        int max = height[0];
        left[0] = height[0];
        for(int i = 1; i < n; i++)
        {
            if(height[i] < max)
            {
                left[i] = max;
            }
            else
            {
                left[i] = height[i];
                max = height[i];
            }
        }
        
        // from right to left
        max = height[n -1];
        right[n - 1] = max;
        for(int i = n - 2; i > -1; i--)
        {
            if(height[i] < max)
            {
                right[i] = max;
            }
            else
            {
                right[i] = height[i];
                max = height[i];
            }
        }
        
        int water = 0;
        for(int i = 0; i < n; i++)
        {
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    
    }
}