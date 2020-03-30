import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int sol = m/10;
        m%=10;
        sol+=m/5;
        m%=5;
        sol+=m;
        return sol;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

