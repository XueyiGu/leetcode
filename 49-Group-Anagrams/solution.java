public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return result;
        }
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            String cur = strs[i];
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if(map.containsKey(str)){
                map.get(str).add(cur);
            }else{
                List<String> item = new ArrayList<String>();
                item.add(cur);
                map.put(str,item);
            }
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
}