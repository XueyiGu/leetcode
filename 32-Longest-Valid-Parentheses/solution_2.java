public class Solution {
    public int longestValidParentheses(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int depth = 0;
        int start = -1;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                depth++;
            }else{
                depth--;
                if(depth < 0){
                    start = i;
                    depth = 0;
                }else if(depth == 0){
                    maxLen = Math.max(maxLen, i - start);
                }
            }
        }
        
        depth = 0;
        start = s.length();
        for(int i = s.length() - 1; i > -1; i--){
            if(s.charAt(i) == ')'){
                depth++;
            }else{
                depth--;
                if(depth < 0){
                    start = i;
                    depth = 0;
                }else if(depth == 0){
                    maxLen = Math.max(maxLen, start - i);
                }
            }
        }
        return maxLen;
    }
}