import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static int getFibonacciLastDigit(int n) {
        if (n <= 1)
            return n;
        
        int previous=0, current=1, temp;
        
        for (int i = 1; i < n; ++i) {
            temp = current;
            current = (previous + current)%10;
            System.out.print(current+" ");
            previous = temp;
        }
        
        return current;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

