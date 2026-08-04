package graphs;
import java.util.*;

public class dsu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]edges=new int[n][m];
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            edges[u][v]=1;
            edges[v][u]=1;
            
        }

        
        
        
    }
    public static int connectedcomponents(int n,int[][]edges){
        int []parent=new int[n];
        int []rank=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(parent[u]!=parent[v]){
                union(parent,rank,u,v);
            }
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i) ans++;
        }
        return ans;


       
    }
    private static void union(int[] parent,int[] rank,int u,int v){
        int parU=find(parent,u);
        int parV=find(parent,v);
        if(parU==parV) return;
        if(rank[parU]<rank[parV]){
            parent[parU]=parV;
        }else if(rank[parU]>rank[parV]){
            parent[parV]=parU;
        }else{
            parent[parV]=parU;
            rank[parU]++;
        }
    }
    private static int find(int[] parent,int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent,parent[u]);
    }
    
}
