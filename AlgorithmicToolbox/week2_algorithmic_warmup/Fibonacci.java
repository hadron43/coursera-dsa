import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    long a=0, b=1, c;
    for(int i=0; i<n; ++i){
      c=a+b;
      a=b;
      b=c;
    }
    return a;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
    in.close();
  }
}
