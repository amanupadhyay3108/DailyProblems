import java.util.*;
public class BuildmatrixWithConditions {
public static void main(String[] args) {
    BuildmatrixWithConditions obj = new BuildmatrixWithConditions();    
    int k = 3;
    int[][] rowConditions = {{1,2},{2,3}};
    int[][] colConditions = {{2,1},{3,2}};
    int[][] result = obj.buildMatrix(k, rowConditions, colConditions);
    System.out.println("Resultant Matrix:");
    for (int[] row : result) {
        System.out.println(Arrays.toString(row));
    }
}


    public List<Integer> toposort(int edges[][],int k){
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=k;i++)adj.add(new ArrayList<>());
        int indegree[]=new int[k+1];
        for(int row[]:edges){
            adj.get(row[0]).add(row[1]);
            indegree[row[1]]++;
        }
        List<Integer>ans=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<=k;i++)
            if(indegree[i]==0)
                q.add(i);

        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0)q.add(nei);
            }
        } 
        if(ans.size()!=k)return new ArrayList<>();
        return ans;       

    } 
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>rows=toposort(rowConditions,k);
        List<Integer>cols=toposort(colConditions,k);
        if(rows.size()==0||cols.size()==0)return new int[0][0];
        int matrix[][]=new int[k][k];
        HashMap<Integer,int[]>map=new HashMap<>();
        for(int i=1;i<=k;i++){
            map.put(i,new int[2]);
        }
        for(int i=0;i<rows.size();i++){
            map.get(rows.get(i))[0]=i;
        }
        for(int i=0;i<cols.size();i++){
            map.get(cols.get(i))[1]=i;
        }
        for(int key:map.keySet()){
            int arr[]=map.get(key);
            matrix[arr[0]][arr[1]]=key;
        }
        return matrix;
    }
}
