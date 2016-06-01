public class Solution {
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() < 2){
            return s;
        }
        
        String result = s.substring(0, 1);
        for(int i = 1; i < s.length(); i++){
            String sub1 = find(s, i - 1, i);
            if(sub1.length() > result.length()){
                result = sub1;
            }
            
            String sub2 = find(s, i, i);
            if(sub2.length() > result.length()){
                result = sub2;
            }
        }
        return result;
    }
    
    //find the longest palindromic substring for the given center
    private String find(String s, int begin, int end){
        while(begin > -1 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}