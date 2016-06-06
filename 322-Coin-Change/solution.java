public class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if(amount < 0){
            return -1;
        }
        int[] change = new int[amount + 1];
        change[0] = 0;
        for(int i = 1; i <= amount; i++){
            change[i] = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && change[i - coins[j]] > -1){
                    min = Math.min(change[i - coins[j]] + 1, min);
                }
            }
            if(min != Integer.MAX_VALUE){
                change[i] = min;
            }
        }
        return change[amount];
    }
}