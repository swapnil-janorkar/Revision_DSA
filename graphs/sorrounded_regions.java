package graphs;
import java.util.*;

class Solution {
    class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public void solve(char[][]board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][]vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            if(board[i][0]=='O'&&!vis[i][0]){
                dfs(board,i,0,vis);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O'&&!vis[i][m-1]){
                dfs(board,i,m-1,vis);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O'&&!vis[0][j]){
                dfs(board,0,j,vis);
            }
        }

        for(int j=0;j<m;j++){
            if(board[n-1][j]=='O'&&!vis[n-1][j]){
                dfs(board,n-1,j,vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(char[][]mat,int r,int c,boolean[][]vis){
        vis[r][c]=true;
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        int n=mat.length;
        int m=mat[0].length;

        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0&&nr<n&&nc>=0&&nc<m){
                if(mat[nr][nc]=='O'&&!vis[nr][nc]){
                    dfs(mat,nr,nc,vis);
                }
            }
        }
    }
}
