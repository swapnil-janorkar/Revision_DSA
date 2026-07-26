package graphs;
import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][]vis=new boolean[n][m];
                    if(dfs(board,word,i,j,0,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    private boolean dfs(char[][]mat,String word ,int r,int c,int idx,boolean[][]vis){
        int n=mat.length;
        int m=mat[0].length;
        if(r<0 || r>=n || c<0 || c>=m || vis[r][c]|| mat[r][c]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        vis[r][c]=true;
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(dfs(mat,word,nr,nc,idx+1,vis)){
                return true;
            }

        }
        vis[r][c]=false;
        return false;

    }
}