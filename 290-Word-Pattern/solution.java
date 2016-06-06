public class Solution {
    public boolean wordPattern(String pattern, String str){
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        int n = pattern.length();
        HashMap<Character, String> map = new HashMap<Character, String>();
        Set<String> visited = new HashSet<String>();
        for(int i = 0; i < n; i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(visited.contains(words[i])){
                    return false;
                }else{
                    map.put(ch, words[i]);
                    visited.add(words[i]);
                }
            }else if(!map.get(ch).equals(words[i])){
                return false;
            }
        }
        return true;
    }
}