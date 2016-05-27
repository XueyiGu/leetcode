public class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!(checkRow(board, i, j) && checkCol(board, i, j) && checkSquare(board, i, j))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean checkRow(char[][] board, int i, int j){
        for(int col = 0; col != j && col < 9; col++){
            if(board[i][col] == board[i][j]){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int i, int j){
        for(int row = 0; row != i && row < 9; row++){
            if(board[row][j] == board[i][j]){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkSquare(char[][] board, int i, int j){
        int m = i / 3;
        int n = j / 3;
        for(int row = m * 3; row < m * 3 + 3; row++){
            for(int col = n * 3; col < n * 3 + 3; col++){
                if(row != i && col != j && board[row][col] == board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}