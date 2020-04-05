import java.util.*;
import java.io.*;

class MaxSlidingWindow{
    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner();

        Deque<Integer> Q = new LinkedList<Integer>();

        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; ++i)
            a[i] = sc.nextInt();
        
        int m = sc.nextInt();

        //Process the first k elements
        for(int i=0; i<m; ++i){
            while(!Q.isEmpty() && a[Q.peekLast()]<a[i])
                Q.removeLast();
            
            Q.addLast(i);
        }
        //Print Asnwer for First Window
        System.out.print(a[Q.peekFirst()]+" ");

        //Slide the Window and print the max element
        for(int i=m; i<n; ++i){
            while(!Q.isEmpty() && a[Q.peekLast()]<a[i])
                Q.removeLast();
            
            if(!Q.isEmpty() && Q.peekFirst()<=i-m)
                Q.removeFirst();
            
            Q.addLast(i);

            System.out.print(a[Q.peekFirst()]+" ");
        }
        
    }
        
}

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = null;
    }

    public String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
/*
8
2 7 3 1 5 2 6 2
4
*/