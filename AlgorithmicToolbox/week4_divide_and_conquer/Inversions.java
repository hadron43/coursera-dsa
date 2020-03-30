import java.util.*;

public class Inversions {
    // private static long merge(int[] a, int)

    private static long merge(int a[], int l, int m, int r){
        long inv = 0;

        int la[] = Arrays.copyOfRange(a, l, m+1);
        int ra[] = Arrays.copyOfRange(a, m+1, r+1);

        int i = 0, j = 0, k = l;
        while(i<la.length && j<ra.length){
            if(la[i]<=ra[j])
                a[k++] = la[i++];
            else{
                a[k++] = ra[j++];
                inv += (m + 1) - (l + i);
            }
        }

        while(i<la.length)
            a[k++] = la[i++];
        
        while(j<ra.length)
            a[k++] = ra[j++];

        return inv;
    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        if(left>=right)
            return 0;
        long numberOfInversions = 0;
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        numberOfInversions += merge(a, left, ave, right);
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
        scanner.close();
    }
}

