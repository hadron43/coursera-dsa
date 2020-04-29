import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    private static long p = 1000000000000000000L;
    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static long codeGen(String s){
        int n = s.length();
        long code = 0;

        for(int i=n-1; i>=0; --i){
            code = ((code*1)%p + p)%p;
            code = ((code + conv(s.charAt(i)))%p + p)%p;
        }

        return code;
    }

    private static long conv(char c){
        if('A'<=c && 'Z'>=c)
            return (long)(c-'A') + 1;
        return (long)(c-'a') + 27;
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();

        //Code for precomputing all relevant hash codes
        long hash[] = new long[n-m+1];
        hash[0] = codeGen(t.substring(0, m));

        long c = (long)Math.pow(1, m-1);

        for(int i=0; i<hash.length-1; ++i){
            hash[i+1] = ((((hash[i] - (conv(t.charAt(i)) * c)*1)%p) + conv(t.charAt(i+m)))%p + p)%p;
        }

        long tHash = codeGen(s);
        for(int i=0; i<hash.length; ++i){
            if(tHash == hash[i] && s.equals(t.substring(i, i+m)))
                occurrences.add(i);
        }
        
        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
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
}

