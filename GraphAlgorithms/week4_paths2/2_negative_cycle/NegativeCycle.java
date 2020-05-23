import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycle {

    private static int dfs(ArrayList<Integer>[] adj, int s, boolean visited[]){
        if(visited[s])
            return -1;

        visited[s] = true;
        for(int i: adj[s]){
            dfs(adj, i, visited);
        }    

        return s;
    }

    private static int checkComponent(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int mother){
        int N = adj.length;
        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[mother] = 0;

        for(int i=0; i<N-1; ++i){
            boolean noRelax = true;
            for(int u=0; u<N; ++u){
                for(int j=0; j<adj[u].size(); ++j){
                    int v = adj[u].get(j);
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+cost[u].get(j)<dist[v]){
                        dist[v] = dist[u]+cost[u].get(j);
                        noRelax = false;
                    }
                }
            }
            if(noRelax)
                break;
        }

        boolean noRelax = true;
        for(int u=0; u<N; ++u){
            for(int j=0; j<adj[u].size(); ++j){
                int v = adj[u].get(j);
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+cost[u].get(j)<dist[v]){
                    dist[v] = dist[u]+cost[u].get(j);
                    noRelax = false;
                }
            }
        }

        if(noRelax)
            return 0;

        return 1;
    }

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int N = adj.length;
        boolean visited[] = new boolean[N];
        for(int i=0; i<N; ++i){
            int temp = dfs(adj, i, visited);

            if(temp!=-1){
                if(checkComponent(adj, cost, temp)==1)
                    return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
        scanner.close();
    }
}

