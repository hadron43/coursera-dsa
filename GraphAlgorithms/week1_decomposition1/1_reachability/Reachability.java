import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    static ArrayList<Integer> visited;

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        if(x==y)
            return 1;
        else{
            int res = 0;
            for(int i: adj[x]){
                if(!visited.contains(i)){
                    visited.add(i);
                    res = res | reach(adj, i, y);
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        visited = new ArrayList<>();
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
        System.out.println(reach(adj, x, y));
    }
}

