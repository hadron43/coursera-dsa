import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PhoneBook {

    private FastScanner in = new FastScanner();
    private String contacts[];
    static BufferedWriter out;

    PhoneBook() throws IOException {
        contacts = new String[10000000];
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"),
                512);
    }

    public static void main(String[] args) throws IOException {
        new PhoneBook().processQueries();
        out.flush();
    }

    private void processQuery() throws IOException {

        String type = in.next();
        int number = in.nextInt();
        String name = "";
        if (type.equals("add")) {
            name = in.next();
        }

        if (type.equals("add")) {
            if(contacts[number]!=null){
                contacts[number] = name;
            }
            else{
                contacts[number] = name;
            }
        } else if (type.equals("del")) {
            if(contacts[number]!=null)
                contacts[number] = null;
        } else {
            String response = "not found";
            if(contacts[number]!=null)
                response = contacts[number];
            out.write(response+"\n");
        }
    }

    public void processQueries() throws IOException {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery();
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
