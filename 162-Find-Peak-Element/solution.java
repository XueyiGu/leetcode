public class Solution {
    public int findPeakElement(int[] nums) 
    {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(mid > 0 && nums[mid - 1] > nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}