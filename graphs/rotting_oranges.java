package graphs;
import java.util.*;

class Solution {
    class pair {
        int r;
        int c;
        int t;

        pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int ans = -1;
        int n = grid.length;
        int m = grid[0].length;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new pair(i, j, 0));
                    c2++;
                } else if (grid[i][j] == 1) {
                    c1++;
                }

            }
        }
        if (c1 == 0)
            return 0;

        if (c2 == 0)
            return -1;
        while (!q.isEmpty()) {
            pair rem = q.remove();
            int r = rem.r;
            int c = rem.c;
            int t = rem.t;
            ans = rem.t;
            if (r + 1 < n && grid[r + 1][c] == 1) {
                q.add(new pair(r + 1, c, t + 1));
                grid[r + 1][c] = 2;
            }
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                q.add(new pair(r - 1, c, t + 1));
                grid[r - 1][c] = 2;
            }
            if (c + 1 < m && grid[r][c + 1] == 1) {
                q.add(new pair(r, c + 1, t + 1));
                grid[r][c + 1] = 2;
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                q.add(new pair(r, c - 1, t + 1));
                grid[r][c - 1] = 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;

    }
}
