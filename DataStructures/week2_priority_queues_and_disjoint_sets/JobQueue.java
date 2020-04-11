import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        Heap threads = new Heap(numWorkers);
        long time = 0;
        for(int i=0; i<jobs.length; ++i){
            long freeTime = threads.a[0].finishTime;
            if(freeTime>0)
                time = freeTime;
            threads.a[0].newTask(time+jobs[i]);
            assignedWorker[i] = threads.a[0].threadId;
            startTime[i] = time;
            threads.heapify(0);

            // threads.print();
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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

class Thread{
    int threadId;

    long finishTime;
    // int timeNeeded;
    // int taskIndex;

    Thread(int threadId){
        this.threadId = threadId;
        finishTime = -1;
        // finishTime = timeNeeded = taskIndex = -1;
    }

    void newTask(long finishTime){//(int taskIndex, int finishTime, int timeNeeded){
        this.finishTime = finishTime;
        // this.timeNeeded = timeNeeded;
        // this.taskIndex = taskIndex;
    }

    boolean isLessThan(Thread t){
        if(this.finishTime < t.finishTime)
            return true;
        if(this.finishTime == t.finishTime && this.threadId < t.threadId)
            return true;
        return false;
    }
}

class Heap{
    int size;
    Thread a[];

    Heap(int size){
        a = new Thread[size];
        this.size = size;
        for(int i=0; i<size; ++i){
            a[i] = new Thread(i);
        }
    }

    void heapify(int i){
        while(i<size){
            int l = 2*i + 1;
            int r = 2*i + 2;
            int smallest = i;

            if(l<size && a[l].isLessThan(a[smallest]))
                smallest = l;

            if(r<size && a[r].isLessThan(a[smallest]))
                smallest = r;

            if(smallest!=i){
                Thread temp = a[i];
                a[i] = a[smallest];
                a[smallest] = temp;

                i = smallest;
            }
            else
                break;
        }
    }

    void print(){
        for(int i=0; i<size; ++i)
            System.out.print(a[i].threadId+" ");
        System.out.println();
    }
}