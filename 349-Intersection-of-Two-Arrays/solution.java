public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return new int[0];
        }
        if(nums2 == null || nums2.length == 0){
            return new int[0];
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], false);
            }
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i], true);
            }
        }
        
        int count = 0;
        for(int i : map.keySet()){
            if(map.get(i) == true){
                count++;
            }
        }
        int[] result = new int[count];
        int j = 0;
        for(int i : map.keySet()){
            if(map.get(i)){
                result[j++] = i;
            }
        }
        return result;
    }
}