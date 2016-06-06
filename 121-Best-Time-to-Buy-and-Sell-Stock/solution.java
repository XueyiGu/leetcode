public class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        int smallest = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= smallest){
                max = Math.max(max, prices[i] - smallest);
            }else{
                smallest = prices[i];
            }
        }
        return max;
    }
}