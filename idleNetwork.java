import java.util.*;
public class idleNetwork {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {5, 6}};
        int[] patience = {0, 2, 1, 3, 2, 1, 4};
        idleNetwork obj = new idleNetwork();
        System.out.println(obj.networkBecomesIdle(edges, patience));
    }           
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=patience.length;
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int row[]:edges){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        dist[0]=0;
        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int node=arr[0];
            int di=arr[1];
            for(int nei:adj.get(node)){
                if(di+1<dist[nei]){
                    dist[nei]=di+1;
                    q.add(new int[]{nei,di+1});
                }
            }
        }
      int maxTime = 0;
        for (int i = 1; i < n; i++) {
            int roundTripTime = 2 * dist[i];
            int lastSentTime = 0;
            if (roundTripTime > patience[i]) {
                int numResends = (roundTripTime - 1) / patience[i];
                lastSentTime = numResends * patience[i];
            }
            int totalTime = lastSentTime + roundTripTime;
            maxTime = Math.max(maxTime, totalTime);
        }

        return maxTime + 1;
    }
}
