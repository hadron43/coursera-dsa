import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int coins[] = {1,3,4};
        int money[] = new int[m+1];
        money[0] = 0;

        for(int i=1; i<=m; ++i){
            money[i] = Integer.MAX_VALUE;
            for(int j=0; j<3; ++j){
                if(coins[j]<=i){
                    int res = money[i-coins[j]] + 1;
                    if(res<money[i])
                        money[i] = res;
                }
            }
        }

        return money[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

