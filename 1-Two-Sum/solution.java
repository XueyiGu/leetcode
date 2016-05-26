public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            int s = target - nums[i];
            if(map.containsKey(s))
            {
                result[0] = map.get(s);
                result[1] = i;
                break;
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}