public class Solution {
    public int titleToNumber(String s) 
    {
        int result = 0;
        int n = s.length();
        int i = n - 1;
        while(i > -1){
            result += (s.charAt(i) - 64) * (int)Math.pow(26, n - i -1);
            i--;
        }
        return result;
    }
}