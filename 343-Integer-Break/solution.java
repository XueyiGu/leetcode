public class Solution {
    
    public int integerBreak(int n){
        if(n <= 3) return n-1; //assuming n >= 2
        return n%3 == 0 ? (int)Math.pow(3, n/3) : n%3 == 1 ? (int)Math.pow(3, n/3-1)*4 : (int)Math.pow(3, n/3)*2;
    
    }
    public int integerBreak1(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        int current = 0;
        int max = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i / 2; j++){
                current = Math.max(j, map.get(j)) * Math.max(i - j, map.get(i - j));
                max = Math.max(current, max);
            }
            map.put(i, max);
        }
        return map.get(n);
    }
}