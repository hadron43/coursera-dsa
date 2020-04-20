import java.util.Scanner;

public class PlacingParentheses {

    static long m[][], M[][], A[];
    static char op[];

    static void minAndMax(int i, int j){
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int k = i; k<j; ++k){
            long a = eval(M[i-1][k-1], M[k][j-1], op[k-1]);
            long b = eval(m[i-1][k-1], M[k][j-1], op[k-1]);
            long c = eval(M[i-1][k-1], m[k][j-1], op[k-1]);
            long d = eval(m[i-1][k-1], m[k][j-1], op[k-1]);

            min = Math.min(Math.min(Math.min(Math.min(a, b), c), d), min);
            max = Math.max(Math.max(Math.max(Math.max(a, b), c), d), max);
        }

        m[i-1][j-1] = min;
        M[i-1][j-1] = max;
    }

    private static long getMaximValue(String exp) {
        A = new long[(exp.length()+1)/2];
        op = new char[(exp.length()-1)/2];
        m = new long[A.length][A.length]; M = new long[A.length][A.length];

        for(int i=0, j=0, k=0; i<exp.length(); ++i){
            if(i%2==0)
                A[j++] = exp.charAt(i) - 48;
            else
                op[k++] = exp.charAt(i);
        }

        int n = A.length;
        for(int i=0; i<A.length; ++i){
            m[i][i] = M[i][i] = A[i];
        }

        for(int s=1; s<=n-1; ++s){
            for(int i=1; i<=n-s; ++i){
                int j = i + s;
                minAndMax(i, j);
            }
        }

        return M[0][A.length-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

