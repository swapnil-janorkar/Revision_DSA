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
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][]vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && !vis[i][j]){
                    ans+=1;
                    bfs(board,i,j,vis);
                   
                }
            }
        }
        return ans;
        
    }
    private void bfs(char[][]mat, int r,int c,boolean[][]vis){
        int n=mat.length;
        int m=mat[0].length;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(r,c));
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            pair rem=q.remove();
            int row=rem.r;
            int col=rem.c;
            for(int i=0;i<4;i++){
                int nr=row+dir[i][0];
                int nc=col+dir[i][1];
                if(nr>=0 && nr<n && nc >=0 && nc<m){
                    if(mat[nr][nc]=='X' && !vis[nr][nc]){
                        vis[nr][nc]=true;
                        q.add(new pair(nr,nc));
                    }
                }
            }

        }

    }
}