public class Solution {
    public int removeDuplicates(int[] nums) 
    {
        if(nums == null){
            return -1;
        }
        
        if(nums.length < 2){
            return 1;
        }
        
        int i = 1;
        int j = 1;
        while(j < nums.length){
            if(nums[j] == nums[j - 1]){
                j++;
            }else{
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}