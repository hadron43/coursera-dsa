import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int binaryLess(int a[], int l, int u, int x){
        int mid = (l+u)/2;
        if(a[mid]==x || mid==0 || mid==a.length-1 || (a[mid]<=x && a[mid+1]>x))
            return mid;
        if(a[mid]<x)
            return binaryLess(a, mid+1, u, x);
        return binaryLess(a, l, mid-1, x);
    }

    private static int binaryMore(int a[], int l, int u, int x){
        int mid = (l+u)/2;
        if(a[mid]==x || mid==0 || mid==a.length-1 || (a[mid]>x && a[mid-1]<x))
            return mid;
        if(a[mid]>x)
            return binaryMore(a, mid+1, u, x);
        return binaryMore(a, l, mid-1, x);
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        
        int restore[] = Arrays.copyOf(points, points.length);
        Arrays.sort(points);
        for(int i=0; i<starts.length; ++i){
            int t1 = binaryMore(points, 0, points.length-1, starts[i]);
            int t2 = binaryLess(points, 0, points.length-1, ends[i]);

            cnt[t1] +=1;
            if(t1==t2 && t2==points.length-1)
                cnt[t2]-=1;
            if(t2!=points.length-1)
                cnt[t2+1] -=1;

            System.out.println(t1+" "+t2);
            // for(int a=0; a<cnt.length; ++a)
            //     System.out.print(cnt[a]+" ");
            // System.out.println();
            // System.out.println(i + " " + t1 + " " +t2 +" "+ cnt[t1]+" " + cnt[t2]);
            // System.out.println(starts[i] + " " + ends[i]);
        }

        for(int i=1; i<cnt.length; ++i){
            cnt[i] = cnt[i] + cnt[i-1];
        }

        // int res[] = new int[cnt.length];
        // for(int i=0; i<points.length; ++i){
        //     res[i] = cnt[binaryLess(points, 0, points.length-1, restore[i])];
        // }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

