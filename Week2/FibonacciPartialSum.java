import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        long sum = current;
        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }
        return sum % 10;
    }
    
    private static long getFibonacciSumFast(long from, long to){
        long _from, _to;
        
        if(from == to){
            return getFibonacciHuge(to, 10);
        } else {
            from += 1;
            to += 2;
            
            _from = (getFibonacciHuge(from, 60)-1)%10;
            _to = (getFibonacciHuge(to, 60)-1)%10;
            if(_from > _to) return _to + 10 - _from;
            else return (_to - _from);

        }
//        if(n<=1) return (int) n;
//        n = (n+2)%60;
//        int fib[] = new int[(int)n+1];
//        fib[0] = 0;
//        fib[1] = 1;
//        for (int i = 2; i < n+1; i++) {
//            fib[i] = (fib[i-1]%10+fib[i-2]%10)%10;
//        }
//        if(fib[(int)n]==0){
//            return 9;
//        }
//        return fib[(int)n]%10-1;
    }
    
    private static int getFibonacciLastDigit(long n) {
        if (n <= 1)
            return (int) n;
        
        int previous=0, current=1, temp;
        
        for (int i = 1; i < n; ++i) {
            temp = current;
            current = (previous + current)%10;
            previous = temp;
        }
        return current;
    }
    private static int fib(long n){
        long previous=0;
        long current =1;
        for (int i = 0; i < n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return (int)current;
    }
    private static int getFibonacciPartialSumFast(long from, long to){
        if(from == to) return (int) getFibonacciLastDigit(from%60);
        from = from % 60;
        to = to % 60;
        from = fib(from+1)-1;
        to=fib(to+2)-1;
//        long a = getFibonacciHuge(from+1,10)-1;
//        long b = getFibonacciHuge(to+2,10)-1;
//        from = (from+2)%10;
//        to = (to+2)%10;
//        int sum =0;
//        for (long i = from; i < to; i++) {
//            sum = (sum%10+getFibonacciLastDigit(i)%10)%10;
//        }
//        System.out.println(a+" "+b);
        return (int)(to-from)%10;
    }
    
    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;
        
        long previous=0, current=1;
        List<Long> pisano = new ArrayList<Long>();
        pisano.add((long) 0); pisano.add((long) 1);
        for (int i = 1; i < n; ++i) {
            long temp = current;
            pisano.add(current = ((previous + current)%m));
            previous = temp;
            if(pisano.get(pisano.size()-2)==0 && pisano.get(pisano.size()-1)==1){
                int length = pisano.size()-2;
                return pisano.get((int) (n%length));
            }
        }
//        System.out.println("Pisano period: "+pisano.toString()+"\nSize: "+pisano.size());
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        long s = getFibonacciSumFast(from, to);
        System.out.println(s);
//        long s2 = getFibonacciPartialSumNaive(from, to);
//        if(s==s2) System.out.println("OK! Answer = "+s);
//        else System.out.println("Wrong Answer! Output = "+s+" Answer = "+s2);
    }
}

