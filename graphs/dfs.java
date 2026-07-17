package graphs;
import java.util.*;

public class dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];
        ans = dfs(1, adj, visited);
    }
    private static List<Integer> dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        while (!st.isEmpty()) {
            int rem = st.pop();
            ls.add(rem);
            for (int x : adj.get(rem)) {
                if (!visited[x]) {
                    st.push(x);
                    visited[x] = true;
                }
            }

        }
        return ls;
    }
    
}
