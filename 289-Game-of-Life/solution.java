public class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                int livedNeis = getLivedNei(board, i, j);
                if(board[i][j] == 1){
                    if(livedNeis == 2 || livedNeis == 3){
                        board[i][j] = 3;
                    }
                }else{
                    if(livedNeis == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    board[i][j] >>= 1;
                }
            }
    }
    
    private int getLivedNei(int[][] nums, int row, int col){
        int count = 0;
        for(int i = row - 1; i <= row + 1; ++i){
            for(int j = col - 1; j <= col + 1; j++){
                if(i > -1 && i < nums.length && j > -1 && j < nums[0].length){
                    count += nums[i][j] & 1;
                }
            }
        }
        count = count - (nums[row][col] & 1);
        return count;
    }
}