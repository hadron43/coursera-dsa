import java.util.*;
import java.io.*;

public class is_bst {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree(Node root, int l, int up){
            if(root.key>l && root.key<up){    
                if(root.left!=-1 && root.right!=-1)
                    return isBinarySearchTree(tree[root.left], l, root.key) && isBinarySearchTree(tree[root.right], root.key, up);
                else if(root.left==-1 && root.right==-1)
                    return true;
                else if(root.left==-1)
                    return isBinarySearchTree(tree[root.right], root.key, up);
                else if(root.right==-1)
                    return isBinarySearchTree(tree[root.left], l, root.key);
            }

            return false;
        }

        boolean isBinarySearchTree() {
        
            if(nodes==0)
                return true;
            return isBinarySearchTree(tree[0], -Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
