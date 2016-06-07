public class Solution {
    public int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxL = 0;
        for(int i = 0; i < m; i++){
            dp[i][0] = (int)(matrix[i][0] - '0');
            maxL = Math.max(maxL, dp[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            dp[0][i] = (int)(matrix[0][i] - '0');
            maxL = Math.max(maxL, dp[0][i]);
        }
        
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    min = Math.min(min, dp[i][j - 1]);
                    dp[i][j] = min + 1;
                }else{
                    dp[i][j] = 0;
                }
                maxL = Math.max(maxL, dp[i][j]);
            }
        }
        return maxL * maxL;
    }
}