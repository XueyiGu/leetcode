public class Solution {
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() < 2){
            return s;
        }
        
        int maxLength = 1;
        String longestSubstring = "" + s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            String sub1 = find(s, i - 1, i);
            if(sub1.length() > longestSubstring.length()){
                longestSubstring = sub1;
            }
            
            String sub2 = find(s, i, i);
            if(sub2.length() > longestSubstring.length()){
                longestSubstring = sub2;
            }
        }
        return longestSubstring;
    }
    
    //find the longest palindromic substring for the given center
    public String find(String s, int begin, int end){
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}