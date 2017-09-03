import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    int[][][] mem = new int[1024][1024][1024];
    
    private static List<Integer> dynamic_sequence(int n) {
        int[] a = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = a[i-1]+1;
            if(i%2==0){
                a[i] = Math.min(a[i/2]+1, a[i]);
            }
            if(i%3==0){
                a[i] = Math.min(a[i/3]+1, a[i]);
            }
        }
        List<Integer> sequence = new ArrayList<Integer>();
        int i = n;
        while(i>1){
            sequence.add(i);
            if(a[i-1]==a[i]-1)
                --i;
            else if(i%2==0 && (a[i/2] == a[i]-1))
                i = i/2;
            else if(i%3==0 && (a[i/3] == a[i]-1))
                i = i/3;
        }
        sequence.add(1);
        return sequence;
    }
    
    private static List<Integer> optimal_sequence(int i, int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            i++;
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dynamic_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
    
    
}

