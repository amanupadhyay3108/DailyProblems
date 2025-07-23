
import java.util.*;
class coinchange{
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;
        coinchange obj = new coinchange();
        System.out.println(obj.coinChange(coins, amount));
    }

    // Memoization
    public int coinChangeMemo(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = choosecoins(coins, n - 1, amount, dp);
        return (ans >= (int) 1e9) ? -1 : ans;
    }

    // Recursive function   
public static int choosecoins(int coins[], int indx, int tar, int dp[][]) {

        if (indx == 0) {
            if (tar % coins[0] == 0)
                return tar / coins[0];
            return (int) 1e9;

        }
        if (dp[indx][tar] != -1)
            return dp[indx][tar];
        int nottake = 0 + choosecoins(coins, indx - 1, tar, dp);
        int take = Integer.MAX_VALUE;
        if (coins[indx] <= tar) {
            take = 1 + choosecoins(coins, indx, tar - coins[indx], dp);
        }
        return dp[indx][tar] = Math.min(take, nottake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i/ coins[0];
            else
                dp[0][i] = (int) 1e9;
        }
        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int nottake = dp[i - 1][tar];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= tar) {
                    take = 1 + dp[i][tar - coins[i]];
                }
                dp[i][tar] = Math.min(take, nottake);
            }
        }

        int ans = dp[n - 1][amount];
        return (ans >= (int) 1e9) ? -1 : ans;

    }
}