package dp;

public class longest_increasing_path {
    
}
class Solution {
    int[][]dp;
    int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        dp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] vis = new boolean[n][m];
                if (!vis[i][j]) {
                    int pl = dfs(matrix, i, j, vis);
                    max = Math.max(max, pl);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] mat, int r, int c, boolean[][] vis) {
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int length = 1;
        int n = mat.length;
        int m = mat[0].length;
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            int prev = mat[r][c];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (!vis[nr][nc] && mat[nr][nc] > prev) {
                    length = Math.max(length, 1 + dfs(mat, nr, nc, vis));
                }
            }
        }
        vis[r][c]=false;
        dp[r][c]=length;
        return length;
    }
}