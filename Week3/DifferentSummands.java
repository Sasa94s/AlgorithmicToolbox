import java.util.Scanner;

public class DifferentSummands {
    static long n = 0;
    static long sum = 0;
    static StringBuilder summands = new StringBuilder();
    private static long optimalSummands(long k, long l){
        while (sum!=n) {   
            long temp;
            if((k-l)<=l) temp = k;
            else temp = l;
            summands.append(temp+" ");
            sum+=temp;
            k-=l;
            ++l;
        }
        return l-1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        
        long x = optimalSummands(n, 1);
        System.out.println(x);
        System.out.println(summands.toString());
    }
}

