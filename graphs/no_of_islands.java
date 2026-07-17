package graphs;
import java.util.*;
class Solution{
    class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    private void bfs(char[][]mat,int r,int c,boolean[][]vis){
        int n = mat.length;
        int m = mat[0].length;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(r,c));
        vis[r][c]=true;
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            pair rem=q.remove();
            int row=rem.r;
            int col=rem.c;
            for(int i=0;i<4;i++){
                int nr=row+dir[i][0];
                int nc=col+dir[i][1];
                if(nr>=0 && nr<n && nc<m && nc>=0 ){
                    if(mat[nr][nc]=='1' && vis[nr][nc]!=true){
                        q.add(new pair(nr,nc));
                        vis[nr][nc]=true;
                    }
                }
            }
        }


        
        

    
        
    }

}
