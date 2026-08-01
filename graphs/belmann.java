package graphs;
import java.util.*;

public class belmann {
    static class pair{
        int v;
        int w;
        pair(int v,int w){
            this.v=v;
            this.w=w;
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
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        int shortest = bellmanFord(n, adj, src, dest);
        System.out.println(shortest);
       
    }
    private static int bellmanFord(int n, ArrayList<ArrayList<pair>> adj, int src, int dest){
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        for(int i=0;i<n-1;i++){
            for(int u=0;u<adj.size();u++){
                for(pair edge : adj.get(u)){
                    int v = edge.v;
                    int w = edge.w;
                    if(ans[u]!=Integer.MAX_VALUE && ans[u]+w<ans[v]){
                        ans[v]=ans[u]+w;
                    }
                }
            }
        }
        boolean flag=false;
        for(int u=0;u<adj.size();u++){
            for(pair edge : adj.get(u)){
                int v = edge.v;
                int w = edge.w;
                if(ans[u]!=Integer.MAX_VALUE && ans[u]+w<ans[v]){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        if(flag){
            System.out.println("Graph contains negative weight cycle");
            return -1;
        }
        return ans[dest];
    }
    
}

