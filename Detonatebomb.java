import java.util.*;
public class Detonatebomb {
public static void main(String[] args) {
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        Detonatebomb obj = new Detonatebomb();
        System.out.println(obj.maximumDetonation(bombs));
    }           
    public boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long distSq = dx * dx + dy * dy;
        long rangeSq = (long) a[2] * a[2];
        return distSq <= rangeSq;
    }

    public void dfs(List<List<Integer>> adj, int node, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(adj, nei, visited, count);
            }
        }
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build directed graph: bomb i -> bomb j if j is within i's range
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && inRange(bombs[i], bombs[j])) {
                    adj.get(i).add(j);
                }
            }
        }

        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int[] count = new int[1];
            dfs(adj, i, visited, count);
            maxDetonated = Math.max(maxDetonated, count[0]);
        }

        return maxDetonated;
    }
}

