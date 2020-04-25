import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int n = adj.length;        
        int color[] = new int[n];
        
        for(int i=0; i<n; ++i)
            color[i] = -1;
        
        color[0] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i: adj[x]){
                if(color[i]==-1){
                    color[i] = color[x] ^ 1;
                    q.add(i);
                }
                if(color[i]==color[x])
                    return 0;
            }
        }

        return 1;
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
        System.out.println(bipartite(adj));
    }
}

