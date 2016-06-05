public class Solution {
    public void solveSudoku(char[][] board){
        dfs(board);
    }
    
    private boolean dfs(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(valid(i, j, board, k)){
                            board[i][j] = k;
                            if(dfs(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    } 
    
    private boolean valid(int i, int j, char[][] board, char a){
        for(int k = 0; k < 9; k++){
            if(board[i][k] == a){
                return false;
            }
        }
        
        for(int k = 0; k < 9; k++){
            if(board[k][j] == a){
                return false;
            }
        }
        
        for(int m = i / 3 * 3; m < i / 3 * 3 + 3; m++){
            for(int n = j / 3 * 3; n < j / 3 * 3 + 3; n++){
                if(board[m][n] == a){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}