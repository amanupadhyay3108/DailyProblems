import java.util.*;
public class extractArtifacts {
public static void main(String[] args) {
    extractArtifacts obj = new extractArtifacts();  
    int n = 2;
    int[][] artifacts = {{0,0,0,0},{0,1,1,1}};
    int[][] dig = {{0,0},{0,1}};
    int result = obj.digArtifacts(n, artifacts, dig);   
    System.out.println("Number of fully extracted artifacts: " + result);
}


    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int dp[][]=new int [n][n];
        int art=0;
        int k=1;
        for(int artifact[]:artifacts){
            art++;
            int r1=artifact[0];
            int c1=artifact[1];
            int r2=artifact[2];
            int c2=artifact[3];
            for(int i=r1;i<=r2;i++){
                for(int j=c1;j<=c2;j++){
                    dp[i][j]=k;
                }
            }
            k++;
        }
        for(int row[]:dig){
            int r=row[0];
            int c=row[1];
            dp[r][c]=0;
        }
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]!=0)set.add(dp[i][j]);
            }
        }
       return art-set.size();
    }
}
