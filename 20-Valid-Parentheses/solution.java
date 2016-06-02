public class Solution {
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        HashMap<Character, Character> left = new HashMap<Character, Character>();
        HashMap<Character, Character> right = new HashMap<Character, Character>();
        left.put('(', ')');
        left.put('{', '}');
        left.put('[', ']');
        
        right.put(')', '(');
        right.put('}', '{');
        right.put(']', '[');
        
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(left.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    char peek = (char)stack.peek();
                    if(peek == right.get(s.charAt(i))){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
                
            }
        }
        
        return stack.isEmpty();
    }
}