public class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        int[] profit = new int[prices.length];
        profit[0] = 0;
        int smallest = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= smallest){
                profit[i] = prices[i] - smallest;
                max = Math.max(max, profit[i]);
            }else{
                smallest = prices[i];
            }
        }
        return max;
    }
}