import java.util.*;
public class criticalConnections {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));

        criticalConnections obj = new criticalConnections();
        List<List<Integer>> result = obj.criticalConnections(n, connections);

        // Print the critical connections
        for (List<Integer> edge : result) {
            System.out.println(edge);
        }
    }   
    
    int time=1;
    public void dfs(int low[],int tin[],boolean vis[],List<List<Integer>>adj,List<List<Integer>>bridge,int node,int parent){
        vis[node]=true;
        tin[node]=low[node]=time;
        time++;
        for(int nei:adj.get(node)){
            if(nei==parent)continue;
            if(!vis[nei]){
                dfs(low,tin,vis,adj,bridge,nei,node);
                low[node]=Math.min(low[nei],low[node]);
                if(low[nei]>tin[node]){
           bridge.add(Arrays.asList(nei, node));
                }
            }else{
 low[node]=Math.min(low[nei],low[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        List<List<Integer>>bridge=new ArrayList<>();
        for(List<Integer>li:connections){
            int u=li.get(0);
            int v=li.get(1);
             adj.get(u).add(v);
             adj.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        int low[]=new int[n];
        int tin[]=new int[n];// insertiontime

       for(int i=0;i<n;i++){
        if(!visited[i]){
            dfs(low,tin,visited,adj,bridge,i,-1);
        }
       }
        return bridge;
    }

}
