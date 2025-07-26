import java.util.*;
public class unreachable {
public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {5, 6}};
        unreachable obj = new unreachable();
        System.out.println(obj.countPairs(n, edges));
    }   
    public void dfs(List<List<Integer>>adj,boolean visited[],int count[],int node){
        count[0]++;
        visited[node]=true;
        for(int nei:adj.get(node)){
            if(!visited[nei]){
                 dfs(adj,visited,count,nei);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        List<Integer>ans=new ArrayList<>();
        boolean visited[]=new boolean[n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int row[]:edges){
            int u=row[0];
            int v=row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count[]=new int[1];
                dfs(adj,visited,count,i);
                ans.add(count[0]);
            }
        }
        long res = 0, sum = 0;
        for (int size : ans) {
            res += sum * size;
            sum += size;
        }
        return res;

    }
}