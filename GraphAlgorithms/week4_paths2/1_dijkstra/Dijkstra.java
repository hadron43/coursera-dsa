import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int n = adj.length;
        int dist[] = new int[n];
            
        for(int i=0; i<n; ++i){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue(new Comp());
        q.add(new Node(s, 0));

        boolean done[] = new boolean[n];

        while(q.size()>0){
            Node temp = q.poll();
            
            if(done[temp.index]==true)
                continue;

            int x = temp.index, xdist = temp.dist;
            for(int i=0; i<adj[x].size(); ++i){
                int aIndex = adj[x].get(i);

                if(dist[aIndex]==Integer.MAX_VALUE)
                    q.add(new Node(aIndex, dist[aIndex]));

                if(xdist + cost[x].get(i) < dist[aIndex]){
                    dist[aIndex] = xdist + cost[x].get(i);
                    q.add(new Node(aIndex, dist[aIndex]));
                }
            }
            done[x] = true;
        }

        if(dist[t]<0 || dist[t]==Integer.MAX_VALUE)
            return -1;
        
        return dist[t];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

class Node{
    int index, dist;

    Node(int index, int dist){
        this.index = index;
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