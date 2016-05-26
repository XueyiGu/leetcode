public class Solution {
    public void nextPermutation(int[] nums) 
    {
        if(nums == null || nums.length < 2){
            return;
        }
        
        int n = nums.length;
        
        int partitionIndex = n - 2;
        while(partitionIndex > -1 && nums[partitionIndex] >= nums[partitionIndex + 1]){
            partitionIndex--;
        }
        
        if(partitionIndex == -1){
            int i = 0; 
            int j = n - 1;
            while(i <= j){
                swap(nums, i++, j--);
            }
            return;
        }
        
        int changeIndex = n - 1;
        while(changeIndex > -1 && nums[changeIndex] <= nums[partitionIndex]){
            changeIndex--;
        }
        
        swap(nums, partitionIndex, changeIndex);
        
        int i = partitionIndex + 1;
        int j = n - 1;
        while(i <= j){
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}