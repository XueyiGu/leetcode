public class Solution {
    public int numSquares(int n) 
    {
        while(n % 4 == 0)
            n = n / 4;
        
        if(n % 8 == 7)
            return 4;
        
        for(int i = 0; i * i <= n; ++i){
            int b = (int)Math.sqrt(n - i * i);
            if(i * i + b * b == n){
                if(b > 0 && i > 0){
                    return 2;
                }else{
                    return 1;
                }
            }
        }
        return 3;
    }
}