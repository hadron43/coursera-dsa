import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int dp[][] = new int[w.length + 1][W+1];

        for(int i=0; i<=w.length; ++i)
          dp[i][0] = 0;

        for(int i=0; i<=W; ++i)
          dp[0][i] = 0;

        for(int i=1; i<=w.length; ++i){
          for(int j=1; j<=W; ++j){
            dp[i][j] = dp[i-1][j];
            
            if(j>=w[i-1]){
              int val = dp[i-1][j-w[i-1]] + w[i-1];
              if(val>dp[i][j])
                dp[i][j] = val;
            }
          }
        }

        return dp[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

