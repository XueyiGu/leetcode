public class Solution {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("+", true);
        map.put("-", true);
        map.put("*", true);
        map.put("/", true);
        int result = 0;
        for(int i = 0; i < tokens.length; i++){
            if(map.containsKey(tokens[i])){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int value = getValue(num1, num2, tokens[i]);
                stack.push(value);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
    
    private int getValue(int num1, int num2, String op){
        if(op.equals("+")){
            return num1 + num2;
        }else if(op.equals("-")){
            return num2 - num1;
        }else if(op.equals("*")){
            return num1 * num2;
        }else{
            return num2 / num1;
        }
    }
}