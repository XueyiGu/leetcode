public class Solution {
    public int longestConsecutive(int[] nums) 
    {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], false);
        }
        
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i])){
                continue;
            }
            
            int length = 1;
            map.put(nums[i], true);
            
            int right = nums[i] + 1;
            while(map.containsKey(right) && map.get(right) == false){
                map.put(right, true);
                length++;
                right++;
            }
            
            int left = nums[i] - 1;
            while(map.containsKey(left) && map.get(left) == false){
                map.put(left, true);
                length++;
                left--;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}