import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
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
        FastScanner scanner = new FastScanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}

