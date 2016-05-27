public class Solution {
    public int trap(int[] height) 
    {
        
        
        if(height == null || height.length < 3){
            return 0;
        }
        int n = height.length;
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            if(height[i] > height[maxIndex]){
                maxIndex = i;
            }
        }
        
        int water = 0;
        int peak = 0;
        for(int i = 0; i < maxIndex; i++){
            if(height[i] > peak){
                peak = height[i];
            }else{
                water += peak - height[i];
            }
        }
        
        peak = 0;
        for(int i = n - 1; i > maxIndex; i--){
            if(height[i] > peak){
                peak = height[i];
            }else{
                water += peak - height[i];
            }
        }
        return water;
    
    
    }
}