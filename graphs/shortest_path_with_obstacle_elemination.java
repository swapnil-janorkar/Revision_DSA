package graphs;
import java.util.*;
class Solution {
    class pair{
        int r;
        int c;
        int ob;
        int pl;
        pair(int r,int c,int ob,int pl){
            this.r=r;
            this.c=c;
            this.ob=ob;
            this.pl=pl;
        }
    }
    public int shortestPath(int[][] grid, int k) {
      int n=grid.length;
        int m=grid[0].length;
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(0,0,0,0));
        boolean[][][]vis=new boolean[n][m][k+1];

        while(!q.isEmpty()){
            pair rem=q.remove();
            int ro=rem.r;
            int co=rem.c;
            int o=rem.ob;
            int pl=rem.pl;
            if(ro==n-1 && co==m-1){
                return pl;
            }
            for(int i=0;i<4;i++){
                int nr=ro+dir[i][0];
                int nc=co+dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int no=o+grid[nr][nc];
                    if(no<=k && !vis[nr][nc][no]){
                        vis[nr][nc][no]=true;
                        q.add(new pair(nr,nc,no,pl+1));
                    }
                }
                    

            }
            

            
        }
        return -1;
    }
    
}