import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int n = adj.length;        
        int dist[] = new int[n];
        
        for(int i=0; i<n; ++i)
            dist[i] = -1;
        
        dist[s] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i: adj[x]){
                if(dist[i]==-1){
                    dist[i] = dist[x] + 1;
                    q.add(i);
                }
            }
        }

        return dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

