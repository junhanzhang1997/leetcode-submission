class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveNei=liveNums(i,j,board);
                if(board[i][j]==1&&liveNei<2){
                    board[i][j]=1;
                }else if(board[i][j]==1&&liveNei>=2&&liveNei<=3){
                    board[i][j]=3;
                }else if(board[i][j]==1&&liveNei>3){
                    board[i][j]=1;
                }else if(board[i][j]==0&&liveNei==3){
                    board[i][j]=2;
                }else{
                    board[i][j]=0;
                }
            }
        }
        //System.out.println(board[1][2]);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    board[i][j]=0;
                }else if(board[i][j]==2){
                    board[i][j]=1;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    private int liveNums(int row,int col,int[][]matrix){
        int lives=0;
        int m=matrix.length;
        int n=matrix[0].length;
        if(row-1>=0&&(matrix[row-1][col]==1||matrix[row-1][col]==3)){
            lives++;
        }
        if(row+1<m&&(matrix[row+1][col]==1||matrix[row+1][col]==3)){
            lives++;
        }
        if(col-1>=0&&(matrix[row][col-1]==1||matrix[row][col-1]==3)){
            lives++;
        }
        if(col+1<n&&(matrix[row][col+1]==1||matrix[row][col+1]==3)){
            lives++;
        }
        if(row-1>=0&&col-1>=0&&(matrix[row-1][col-1]==1||matrix[row-1][col-1]==3)){
            lives++;
        }
        if(row+1<m&&col-1>=0&&(matrix[row+1][col-1]==1||matrix[row+1][col-1]==3)){
            lives++;
        }
        if(row+1<m&&col+1<n&&(matrix[row+1][col+1]==1||matrix[row+1][col+1]==3)){
            lives++;
        }
        if(row-1>=0&&col+1<n&&(matrix[row-1][col+1]==1||matrix[row-1][col+1]==3)){
            lives++;
        }
        return lives;
    }
}