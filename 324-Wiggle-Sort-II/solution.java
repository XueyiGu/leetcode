public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2, 0, n - 1);
        
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private int findKthLargest(int[] nums, int k, int begin, int end){
        
        int pivot_pos = partition(nums, begin, end);
        int pivot_rank = pivot_pos - begin + 1;
        if(pivot_rank == k){
            return nums[pivot_pos];
        }else if(pivot_rank > k){
            return findKthLargest(nums, k, begin, pivot_pos - 1);
        }else{
            return findKthLargest(nums, k - pivot_rank, pivot_pos + 1, end);
        }
    }
    
    private int partition(int[] nums, int begin, int end)
    {
        int pivot = nums[end];
        int cur = begin;
        int i = begin - 1;
        while(cur < end)
        {
            if(nums[cur] >= pivot)
            {
                i++;
                swap(nums, i, cur);
            }
            cur++;
        }
        swap(nums, cur, i + 1);
        
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}