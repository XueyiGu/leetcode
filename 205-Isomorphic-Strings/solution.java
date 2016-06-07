public class Solution {
    public boolean isIsomorphic(String s, String t){
        int m = s.length();
        int n = t.length();
        if(m != n){
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> used = new HashSet<Character>();
        for(int i = 0; i < m; i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(!map.containsKey(schar)){
                if(used.contains(tchar)){
                    return false;
                }else{
                    map.put(schar, tchar);
                    used.add(tchar);
                }
            }else{
                if(map.get(schar) != tchar){
                    return false;
                }
            }
        }
        return true;
    }
}