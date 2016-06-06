public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums2.length; i++){
            int c = nums2[i];
            if(map.containsKey(c)){
                list.add(c);
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}