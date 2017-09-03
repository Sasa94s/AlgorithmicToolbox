import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    private static int getFibonacciSumNaive2(long n) {
        if (n <= 1)
            return (int) n;
        
        int previous=0, current=1, sum=1;
        
        for (long i = 1; i < n; ++i) {
            int temp = current;
            current = (previous + current)%10;
            //System.out.print(current+" ");
            sum = (sum+current)%10;
            previous = temp;
        }
        
        return sum%10;
    }
    private static int getFibonacciSumFast(long n){
        
        if(n<=1) return (int) n;
        n = (n+2)%60;
        int fib[] = new int[(int)n+1];
        fib[0] = 0;
        fib[1] = 1;
        
        for (int i = 2; i < n+1; i++) {
            fib[i] = (fib[i-1]%10+fib[i-2]%10)%10;
//            if(pisano.get(pisano.size()-2)==0 && pisano.get(pisano.size()-1)==1){
//                int length = pisano.size()-2;
//                return pisano.get((int)(n%length));
//            }
        }
        if(fib[(int)n]==0){
            return 9;
        }
        
        return fib[(int)n]%10-1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive2(n);
        int s2 = getFibonacciSumFast(n);
        //if(s==s2) System.out.println("OK! Answer = "+s);
        //else System.out.println("Wrong Answer! Output = "+s2+" Answer = "+s);
        System.out.println(s2);
    }
}

