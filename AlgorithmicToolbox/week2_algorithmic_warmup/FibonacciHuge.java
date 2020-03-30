import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, int m) {
        Vector<Integer> list = new Vector<>();
        list.add(0);
        int size = 1;
        int curr = 1;
        while(curr!=0 || list.get(size-1)!=1){
            list.add(curr);
            curr = (list.get(size-1) + curr)%m;
            size++;
        }
        

        // System.out.println(list);
        return list.get((int)(n%size));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeNaive(n, m));
        scanner.close();
    }
}

