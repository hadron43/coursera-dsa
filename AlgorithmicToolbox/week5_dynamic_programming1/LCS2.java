import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int dp[][] = new int[a.length+1][b.length+1];
        dp[0][0] = 0;

        for(int i=1; i<=a.length; ++i)
            dp[i][0] = 0;
        for(int i=1; i<=b.length; ++i)
            dp[0][i] = 0;

        for(int i=1; i<=a.length; ++i){
            for(int j=1; j<=b.length; ++j){
                if(a[i-1]==b[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

