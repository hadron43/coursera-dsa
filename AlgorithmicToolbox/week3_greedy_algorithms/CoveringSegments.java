import java.util.*;

public class CoveringSegments {

    private static void sort(Segment[] segments){
        for(int i=0; i<segments.length-1; ++i)
            for(int j=0; j<segments.length-1-i; ++j)
                if(segments[j].end>segments[j+1].end){
                    Segment temp = segments[j];
                    segments[j] = segments[j+1];
                    segments[j+1] = temp;
                }
    }

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int res[] = new int[segments.length];
        int size=0;
        sort(segments);
        
        for(int i=0; i<segments.length;){
            res[size] = segments[i].end;
            while(i<segments.length && segments[i].start<=res[size])
                i++;
            size++;
        }
        int ans[] = new int[size];
        for(int i=0; i<size; ++i)
            ans[i] = res[i];
        return ans;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
