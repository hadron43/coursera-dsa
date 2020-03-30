import java.util.*;

public class FibonacciSumLastDigit {

    private static int getFibonacciHugeNaive(long n, int m) {
        Vector<Integer> list = new Vector<>();
        list.add(0);
        int size = 1;
        int curr = 1;
        while(curr!=0 || list.get(size-1)!=1){
            list.add(curr);
            curr = (list.get(size-1) + curr)%m;
            size++;
        }
        return list.get((int)(n%size));
    }

    private static long getFibonacciSumNaive(long n) {
        int temp = getFibonacciHugeNaive(n+2, 10);
        if(temp==0)
            return 9;
        else
            return temp-1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
        scanner.close();
    }
}

