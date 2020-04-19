import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c){
        int dp[][][] = new int[a.length+1][b.length+1][c.length+1];

        for(int i=1; i<=a.length; ++i)
            dp[i][0][0] = 0;
        for(int i=1; i<=b.length; ++i)
            dp[0][i][0] = 0;
        for(int i=1; i<=c.length; ++i)
            dp[0][0][i] = 0;
        
        for(int i=1; i<=a.length; ++i){
            for(int j=1; j<=b.length; ++j){
                for(int k=1; k<=c.length; ++k){
                    if(a[i-1]==b[j-1] && b[j-1]==c[k-1])
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    else
                        dp[i][j][k] = Integer.max(Integer.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
                }
            }
        }

        return dp[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

