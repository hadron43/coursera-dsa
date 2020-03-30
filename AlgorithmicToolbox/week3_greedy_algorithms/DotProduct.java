import java.util.*;

public class DotProduct {

    private static void sort(int A[]){
        for(int i=0; i<A.length-1; ++i){
            for(int j=0; j<A.length-i-1; ++j)
                if(A[j]>A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
        }
    }

    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        sort(a); sort(b);
        for(int i=0; i<a.length; ++i){
            result+=(long)a[i]*b[i];
            // System.out.println(a[i] + " " +b[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

