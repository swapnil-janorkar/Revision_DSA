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

    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ans=bfs(grid,i,j,vis);
                }
            }
        }
        return ans;
    }

    private int bfs(int[][]grid,int r,int c,boolean[][]vis){
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(r,c));
        vis[r][c]=true;
        int perimeter=0;
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            pair rem=q.remove();
            int row=rem.r;
            int col=rem.c;

            for(int i=0;i<4;i++){
                int nr=row+dir[i][0];
                int nc=col+dir[i][1];

                if(nr<0 || nr>=n || nc<0 || nc>=m){
                    perimeter++;
                }
                else if(grid[nr][nc]==0){
                    perimeter++;
                }
                else if(grid[nr][nc]==1 && !vis[nr][nc]){
                    q.add(new pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }
        }
        return perimeter;
    }
}