import java.util.*;
public class redundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        redundantConnection obj = new redundantConnection();
        System.out.println(Arrays.toString(obj.findRedundantConnection(edges)));
    }       
   public int findpar(int node,int par[]){
        if(par[node]==node)return node;
        return par[node]=findpar(par[node],par);
    }
  
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int par[]=new int[n+1];
        for(int i=0;i<=n;i++)par[i]=i;
        for(int row[]:edges){
            int pu=findpar(row[0],par);
            int pv=findpar(row[1],par);
            if(pu==pv)return row;
            par[pu]=pv;
        }
        return new int[]{0};

    }
}
