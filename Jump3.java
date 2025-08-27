import java.util.*;
public class Jump3 {
    public static void main(String[] args) {
        Jump3 obj = new Jump3();
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean result = obj.canReach(arr, start);
        System.out.println("Can reach zero: " + result);
    }   
    public boolean canReach(int[] arr, int start) {
       Queue<Integer>q=new LinkedList<>();
       q.add(start);
       while(!q.isEmpty()){
        int curr=q.poll();
        if(arr[curr]==0)return true;
         if (arr[curr]<0) continue;   
        if(curr+arr[curr]<arr.length){
            q.add(arr[curr]+curr);
        }
        if(curr-arr[curr]>=0)q.add(curr-arr[curr]);
        arr[curr]=-arr[curr];
       }
       return false;
    }
}

