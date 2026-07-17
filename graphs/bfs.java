package graphs;
import java.util.*;

public class bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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
        bfs(1, adj, visited);
    }

    private List<Integer> bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        ArrayList<Integer> ls=new ArrayList<>();
        while(!q.ismpty()){
            int rem=q.remove();
            ls.add(rem);
            for(int x: adj.get(rem)){
                q.add(x);
                visited[x]=true;
            }

        }
        return ls;
    }
}

