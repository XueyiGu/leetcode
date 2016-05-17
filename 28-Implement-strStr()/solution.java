public class Solution {
    public int strStr(String haystack, String needle) 
    {
        if(needle == null || needle.length() == 0){
            return 0;
        } 
        
        if(haystack.length() < needle.length()){
            return -1;
        }
        
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(match(haystack, i, needle)){
                    return i;
                }
            }
        }
        return -1;
    }
    
    private boolean match(String target, int i, String needle){
        if(target.length() - i < needle.length()){
            return false;
        }
        
        for(int j = 0; j < needle.length(); j++){
            if(target.charAt(i + j) != needle.charAt(j)){
                return false;
            }
        }
        return true;
    }
}