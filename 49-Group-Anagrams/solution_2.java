public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return result;
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(key, item);
            }
        }
        for(String key : map.keySet()){
            List<String> temp = map.get(key);
            Collections.sort(temp);
            result.add(temp);
        }
        return result;
    }
    
}