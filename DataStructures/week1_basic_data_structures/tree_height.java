import java.util.*;
import java.io.*;

public class tree_height {

	public static void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}

class FastScanner {
	StringTokenizer tok = new StringTokenizer("");
	BufferedReader in;

	FastScanner() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (!tok.hasMoreElements())
			tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}

class Node{
	List<Node> children;

	Node(){
		children = new ArrayList<Node>();
	}
}

class TreeHeight {
	int n;
	int parent[];
	
	void read() throws IOException {
		FastScanner in = new FastScanner();
		n = in.nextInt();
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = in.nextInt();
		}
	}

	int height(Node n){
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		q.add(null);
		int ans = 0;
		Node temp;
		while(!q.isEmpty()){
			temp = q.poll();
			while(temp!=null){
				for(Node i: temp.children)
					q.add(i);
				temp = q.poll();
			}
			
			ans++;
			if(!q.isEmpty())
				q.add(null);
		}
		return ans;
	}

	int computeHeight() {
		Node child[] = new Node[n], root = null;

		for(int i=0; i<n; ++i)
			child[i] = new Node();

		for(int child_index=0; child_index<n; ++child_index){
			int parent_index = parent[child_index];
			if(parent_index==-1)
				root = child[child_index];
			else
				child[parent_index].children.add(child[child_index]);

		}

		int ans = height(root);

		return ans;
	}
}