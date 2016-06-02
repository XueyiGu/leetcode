public class Solution {
    public int longestValidParentheses(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int maxLen = 0;
        int last = -1;
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    last = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i - last);
                    }else{
                        maxLen = Math.max(maxLen, i - (int)stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}