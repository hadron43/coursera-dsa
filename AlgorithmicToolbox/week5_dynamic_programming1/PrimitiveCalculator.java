import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        
        int numbers[] = new int[n];
        numbers[0] = 0;

        int noOfSteps;
        int ans[] = new int[3];
        for(int i=2; i<=n; ++i){
            ans[0] = ans[1] = ans[2] = Integer.MAX_VALUE;

            ans[0] = numbers[(i-1)-1] + 1;
            if(i%2==0)
                ans[1] = numbers[i/2 - 1] + 1;

            if(i%3==0)
                ans[2] = numbers[i/3 - 1] + 1;
            
            if(ans[0]<ans[1] && ans[0]<ans[2]){
                noOfSteps = ans[0];
            }
            else if(ans[1]<ans[2]){
                noOfSteps = ans[1];
            }
            else{
                noOfSteps = ans[2];
            }

            numbers[i-1] = noOfSteps;
        }

        int temp = n, op;
        while(temp>1){
            op = 1;
            if(temp%3==0)
                op = 3;
            else if(temp%2==0 && numbers[temp/2 - 1]<=numbers[temp-1 - 1])
                op = 2;
            sequence.add(temp);
            if(op == 1)
                temp-=1;
            else if(op==2)
                temp/=2;
            else
                temp/=3;
        }
        sequence.add(1);

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
