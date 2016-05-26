public class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] > nums[i - 1]){
                int target = 0 - nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    if(nums[j] + nums[k] == target){
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        result.add(item);
                        j++;
                        k--;
                        while(j < k && nums[j] == nums[j - 1]){
                            j++;
                        }
                    
                        while(k > j && nums[k + 1] == nums[k]){
                            k--;
                        }
                    }else if(nums[j] + nums[k] < target){
                        j++;
                        while(j < k && nums[j] == nums[j - 1]){
                            j++;
                        }
                    }else{
                        k--;
                        while(k > j && nums[k + 1] == nums[k]){
                            k--;
                        }
                    }
                }
            }
            
        }
        return result;
    }
}