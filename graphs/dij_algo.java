package graphs;
import java.util.*;
public class dij_algo {
    static class pair implements Comparable<pair>{
        int v;
        int w;
        pair(int v,int w){
            this.v=v;
            this.w=w;
        }
        public int compareTo(pair o){
            return this.w-o.w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        int shortest = dij(n, adj, src, dest);
        System.out.println(shortest);
    }
    private static int dij(int n, ArrayList<ArrayList<pair>> adj, int src, int dest){
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));
        while(!pq.isEmpty()){
            pair rem = pq.remove();
            int vtx = rem.v;
            int wsf = rem.w;
            if(wsf > ans[vtx]){
                continue;
            }
            for(pair nbr : adj.get(vtx)){
                int v = nbr.v;
                int w = nbr.w;
                if(wsf + w < ans[v]){
                    ans[v] = wsf + w;
                    pq.add(new pair(v, ans[v]));
                }
            }

        }
        return ans[dest];
    }

   
}

