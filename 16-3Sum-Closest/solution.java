public class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] > nums[i - 1]){
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    int gap = Math.abs(sum - target);
                    
                    if(gap < minGap){
                        minGap = gap;
                        result = sum;
                    }
                    
                    if(sum < target){
                        j++;
                        while(j < k && nums[j] == nums[j - 1]){
                            j++;
                        }
                    }else{
                        k--;
                        while(j < k && nums[k] == nums[k + 1]){
                            k--;
                        }
                    }
                }
            }
        }
        return result;
    }
}