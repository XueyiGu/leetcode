public class Solution {
    public int strStr(String haystack, String needle){
        if(haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        
        if(needle.length() == 0){
            return 0;
        }
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0) && match(haystack, needle, i)){
                return i;
            }
        }
        return -1;
    }
    
    private boolean match(String haystack, String needle, int i){
        int j = 0;
        while(j < needle.length()){
            if(haystack.charAt(i) != needle.charAt(j)){
                return false;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}