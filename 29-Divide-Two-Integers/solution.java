public class Solution {
    public int divide(int dividend, int divisor) 
    {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        int result = 0;
        while(pDividend >= pDivisor){
            int offset = 0;
            while((pDivisor << offset) <= pDividend){
                offset++;
            }
            
            result += (1 << (offset - 1));
            pDividend -= (pDivisor << (offset - 1));
        }
        
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0){
            return result;
        }else{
            return -result;
        }
    }
}