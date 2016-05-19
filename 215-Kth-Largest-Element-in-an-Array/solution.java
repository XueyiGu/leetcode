public class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    private int findKthLargest(int[] nums, int begin, int end, int k){
        int pivot_position = partition(nums, begin, end);
        int pivot_rank = pivot_position - begin + 1;
        if(pivot_rank == k){
            return nums[pivot_position];
        }else if(pivot_rank > k){
            return findKthLargest(nums, begin, pivot_position - 1, k);
        }else{
            return findKthLargest(nums, pivot_position + 1, end, k - pivot_rank);
        }
    }
    
    private int partition(int[] nums, int begin, int end){
        int pivot = nums[end];
        int i = begin - 1;
        int current = begin;
        while(current < end){
            if(nums[current] > pivot){
                i++;
                swap(nums, i, current);
            }
            current++;
        }
        swap(nums, i + 1, end);
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}