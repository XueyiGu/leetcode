public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], false);
            }
        }
        
        int count = 0;
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) == false){
                count++;
                map.put(nums2[i], true);
            }
        }
        
        int[] result = new int[count];
        int i = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) == true){
                result[i] = key;
                i++;
            }
        }
        return result;
    }
}