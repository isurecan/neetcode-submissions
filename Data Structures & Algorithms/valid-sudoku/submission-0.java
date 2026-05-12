class Solution {
    public boolean isValidSudoku(char[][] board) {
     for(int row=0; row<9;row++){
        for(int col=0; col<9;col++){
            if(!isValid(row,col,board)) return false;
        }
      } 
      return true; 
    }

    private boolean isValid(int row, int col, char[][] board){
        if(board[row][col]=='.') return true;

        for(int i=0;i<9;i++){
            if(board[row][col]==board[row][i] && i!=col) return false;
            if(board[row][col]==board[i][col]&& i!=row) return false;
            if((3*(row/3)+(i/3))!=row && (3*(col/3)+(i%3))!=col &&
            board[row][col]==board[(3*(row/3)+(i/3))][(3*(col/3)+(i%3))])       return false;

        }
        return true;
    }
}
