public class Solution {
    public int romanToInt(String s) 
    {
        int result = 0;
        if(s == null || s.length() == 0){
            return result;
        }
        
        int pre = map(s.charAt(s.length() - 1));
        result = pre;
        for(int i = s.length() - 2; i > -1; i--){
            int num = map(s.charAt(i));
            if(num < pre){
                result = result - num;
            }else{
                result += num;
            }
            pre = num;
        }
        return result;
    }
    
    private int map(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}