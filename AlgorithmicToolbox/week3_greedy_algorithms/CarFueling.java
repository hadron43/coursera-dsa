import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int pos = 0, i = 0, refil=0;

        if(tank<stops[0] || tank<dist - stops[stops.length-1])
            return -1;

        while(pos<dist){
            int t1 = pos+tank;

            if(t1>=dist)
                break;

            if(t1<stops[i])
                return -1;

            while(i<stops.length && stops[i]<=t1){
                i++;
            }
            pos = stops[i-1];
            // System.out.println(pos);
            refil++;
        }
        return refil;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
