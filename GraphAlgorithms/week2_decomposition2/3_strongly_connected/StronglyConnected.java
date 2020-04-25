import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        ArrayList<Integer> revAdj[] = (ArrayList<Integer>[]) new ArrayList[adj.length];
        int ans = 0;
        for (int i = 0; i < adj.length; i++) {
            revAdj[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<adj.length; ++i){
            for(int x: adj[i])
                revAdj[x].add(i);
        }

        deleted = new int[adj.length];
        int post[] = new int[adj.length];
        int used[] = new int[adj.length];

        counter = 0;
        for(int i=0; i<adj.length; ++i){
            if(used[i]==0)
                dfs(revAdj, post, used, i);
        }

        while(noOfDeletions<adj.length){
            int highestPost = -1;
            for(int i=0; i<post.length; ++i){
                if(deleted[i]==1)
                    continue;

                if(highestPost==-1){
                    highestPost = i;
                    continue;
                }

                if(post[i]>post[highestPost])
                    highestPost = i;

            }
            delete(adj, highestPost);
            ans++;
        }
        return ans;
    }
    static int counter, deleted[];
    public static void dfs(ArrayList<Integer>[] adj, int[] post, int[] used, int x){
        used[x] = 1;
        for(int i: adj[x])
            if(used[i]==0)
                dfs(adj, post, used, i);

        post[x] = ++counter;
    }
    static int noOfDeletions;

    static void delete(ArrayList<Integer>[] adj, int highestPost){
        deleted[highestPost] = 1;
        noOfDeletions++;
        for(int i: adj[highestPost])
            if(deleted[i]==0)
                delete(adj, i);
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

