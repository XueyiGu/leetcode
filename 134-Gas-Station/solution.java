public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n = gas.length;
        int sum = 0;
        int total = 0;
        int start = -1;
        for(int i = 0; i < n; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            
            if(sum < 0){
                start = i;
                sum = 0;
            }
        }
        if(total >= 0){
            return start + 1;
        }else{
            return -1;
        }
    }
}