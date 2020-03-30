import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    if(a==0)
      return b;
    return gcd_naive(b%a , a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a,b));
  }
}
