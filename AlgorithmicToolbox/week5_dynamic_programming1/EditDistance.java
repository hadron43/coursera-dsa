import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int dp[][] = new int[s.length()+1][t.length()+1];
    dp[0][0] = 0;

    //Filling the first colum and first row of the table
    for(int i=1; i<=s.length(); ++i)
      dp[i][0] = i;
    for(int i=1; i<=t.length(); ++i)
      dp[0][i] = i;

    //Filling up of the table
    for(int i=1; i<=s.length(); ++i){
      for(int j=1; j<=t.length(); ++j){
        if(s.charAt(i-1)==t.charAt(j-1))
          dp[i][j] = dp[i-1][j-1];
        else{
          if(dp[i-1][j-1]<dp[i-1][j] && dp[i-1][j-1]<dp[i][j-1])
            dp[i][j] = dp[i-1][j-1] + 1;
          else if(dp[i-1][j]<dp[i][j-1])
            dp[i][j] = dp[i-1][j] + 1;
          else
            dp[i][j] = dp[i][j-1] + 1;
        }
      }
    }

    return dp[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
