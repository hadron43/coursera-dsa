import java.util.*;

public class ConnectingPoints {

    private static double dist(int x1, int y1, int x2, int y2){
        double d = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
        return Math.pow(d, 0.5);
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        
        int n = x.length;
        Node arr[] = new Node[(n*(n-1))/2];
        int index = 0;
        for(int i=0; i<x.length; ++i){
            for(int j=i+1; j<x.length; ++j){
                arr[index++] = new Node(i, j, dist(x[i], y[i], x[j], y[j]));
            }
        }

        Arrays.sort(arr, new Comp());
        DisjointSet d = new DisjointSet(n);

        for(int i=0; i<arr.length; ++i){
            if(d.find(arr[i].n1)==d.find(arr[i].n2))
                continue;

            // System.out.println(arr[i].n1+" "+arr[i].n2+" "+arr[i].dist+" ");    
            result += arr[i].dist;
            d.union(arr[i].n1, arr[i].n2);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
        scanner.close();
    }
}

class Node{
    int n1, n2;
    double dist;

    Node(int i, int j, double dist){
        this.n1 = i;
        this.n2 = j;
        this.dist = dist;
    }
}

class Comp implements Comparator<Node>{
    @Override
    public int compare(Node arg0, Node arg1) {
        if(arg0.dist<arg1.dist)
            return -1;

        if(arg1.dist<arg0.dist)
            return 1;

        return 0;
    }
}

class DisjointSet{
    int parent[];
    int rank[];

    DisjointSet(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i=0; i<size; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        while(parent[x]!=x)
            x = parent[x];

        return x;
    }

    public void union(int i, int j){
        i = find(i);
        j = find(j);

        if(rank[i]>rank[j]){
            parent[j] = i;
        }
        else{
            parent[i] = j;
            if(rank[i]==rank[j])
                rank[j]++;
        }
    }
}