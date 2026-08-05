package graphs;
import java.util.*;

class Solution{
    class pair{
        int vtx;
        int wt;
        int stops;
        pair(int vtx,int wt,int stops){
            this.vtx=vtx;
            this.wt=wt;
            this.stops=stops;
        }
        
    }
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k){
        List<List<pair>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]e:flights){
            int u=e[0];
            int v=e[1];
            int d=e[2];
            graph.get(u).add(new pair(v,d,0));
        }
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(src,0,0));
        int []dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            pair rem=q.remove();
            int u=rem.vtx;
            int wt=rem.wt;
            int stops=rem.stops;
            if(stops>k)continue ;
            
            for(pair nbr:graph.get(u)){
                int v=nbr.vtx;
                int cost=nbr.wt;
                if(wt+cost<dist[v] && stops<=k ){
                    dist[v]=wt+cost;
                    q.add(new pair(v,wt+cost,stops+1));
                    
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}