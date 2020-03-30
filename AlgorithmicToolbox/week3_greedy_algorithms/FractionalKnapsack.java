import java.util.Scanner;

public class FractionalKnapsack {
    private static void swap(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void swap(double A[], int i, int j){
        double temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void sort(double A[], int B[], int C[]){
        for(int i=0; i<A.length-1; ++i){
            for(int j=0; j<A.length-i-1; ++j)
                if(A[j]<A[j+1]){
                    swap(A, j, j+1);
                    swap(B, j, j+1);
                    swap(C, j, j+1);
                }
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights, double ratio[]) {
        double value = 0;
        sort(ratio, values, weights);
        int i=0;
        while(capacity>0 && i<values.length){
            if(capacity>=weights[i]){
                value+=values[i];
                capacity-=weights[i];
            }
            else{
                value+=capacity*(ratio[i]);
                capacity=0;
                break;
            }
            i++;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            ratio[i] = (double)values[i]/weights[i];
        }
        System.out.println(getOptimalValue(capacity, values, weights, ratio));
    }
} 
