import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    static boolean visited[];

	private static boolean explore(ArrayList<Integer>[] adj, int i, ArrayList<Integer> curr){
        if(curr.contains(i)){
            return false;
        }
        curr.add(i);

        if(visited[i]==true)
            return true;
        visited[i] = true;
        
		boolean ans = true;
		for(int j: adj[i]){
			ans = ans & explore(adj, j, new ArrayList<>(curr));
		}
		return ans;
		
	}

    private static int acyclic(ArrayList<Integer>[] adj) {
        int n = adj.length;
        visited = new boolean[n];
        boolean ans = true;
        for(int i=0; i<n; ++i){
        	if(visited[i]==false){
                ans = ans & explore(adj, i,  new ArrayList<Integer>());
            }

        	if(ans==false)
        		return 1;
        }

        return 0;
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
        }
        System.out.println(acyclic(adj));
    }
}

