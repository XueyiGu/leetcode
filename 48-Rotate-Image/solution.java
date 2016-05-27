public class Solution {
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        //沿着副对角线翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                swap(matrix, i, j, n - j - 1, n - i - 1);
            }
        }
        
        //沿着水平中线翻转
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                swap(matrix, i, j, n - i - 1, j);
            }
        }
        
    }
    
    private void swap(int[][] matrix, int i, int j, int m, int n){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}