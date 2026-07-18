package graphs;
import java.util.*;
public class Solution {
    class pair{
        int r;
        int c;
        pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int area=bfs(grid,i,j,vis);
                    ans=Math.max(ans,area);
                    
                }
            }
        }
        return ans;
        
    }
    private int bfs(int [][]grid,int r,int c,boolean[][]vis){
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(r,c));
        vis[r][c]=true;
        int count=1;
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            pair rem=q.remove();
            int row=rem.r;
            int col=rem.c;
            for(int i=0;i<4;i++){
                int nr=row+dir[i][0];
                int nc=col+dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    if(grid[nr][nc]==1 && !vis[nr][nc]){
                        count++;
                        q.add(new pair(nr,nc));
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        return count;
        
    }

} 
