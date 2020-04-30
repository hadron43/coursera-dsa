import java.util.*;
import java.io.*;

public class substring_equality {
	static public class Solver {
		private String s;
		private static long m1 = 1000000007, m2 = 1000000009;
		private long x;
		private long[] h1, h2;
		private long[] pow1, pow2;
		public Solver(String s) {
			this.s = s;
			this.x = (long)(Math.random()*1000000000);
			// this.x = 1;
			
			int n = s.length();
			h1 = new long[n + 1];
			h2 = new long[n + 1];

			h1[0] = h2[0] = 0;
			for(int i=1; i<=n; ++i){
				h1[i] = ((x*h1[i-1] + s.charAt(i-1)) % m1 + m1)%m1;
				h2[i] = ((x*h2[i-1] + s.charAt(i-1)) % m2 + m2)%m2;
			}

			pow1 = new long[n+1];
			pow2 = new long[n+1];
			pow1[0] = pow2[0] = 1;
			for(int i=1; i<=n; ++i){
				pow1[i] = (pow1[i-1] * x%m1)%m1;
				pow2[i] = (pow2[i-1] * x%m2)%m2;
			}
		}
		public boolean ask(int a, int b, int l) {
			long checka, checkb;
			checka = ((h1[a+l] - pow1[l] * h1[a])%m1 + m1)%m1;
			checkb = ((h1[b+l] - pow1[l] * h1[b])%m1 + m1)%m1;

			if(checka==checkb){
				checka = ((h2[a+l] - pow2[l] * h2[a])%m2 + m2)%m2;
				checkb = ((h2[b+l] - pow2[l] * h2[b])%m2 + m2)%m2;

				if(checka==checkb)
					return true;
			}
			return false;
		}
	}

	public void run() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		int q = in.nextInt();
		Solver solver = new Solver(s);
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt();
			out.println(solver.ask(a, b, l) ? "Yes" : "No");
		}
		out.close();
	}

	static public void main(String[] args) throws IOException {
	    new substring_equality().run();
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
}
