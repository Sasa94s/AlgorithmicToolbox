import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    static List<Character> op = new ArrayList<>();
    static List<Long> nums = new ArrayList<>();
    static long[][] m, M;
    private static long getMaximValue(String exp) {
        exp = exp.replaceAll(" ", "");
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'){
                nums.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
                op.add(exp.charAt(i));
            } else {
                num.append(exp.charAt(i));
            }
        }
        nums.add(Long.parseLong(num.toString()));

        int n = nums.size();
        m = new long[n][n];
        M = new long[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = nums.get(i);
            M[i][i] = nums.get(i);
        }
        for (int s = 0; s < n-1; s++) {
            for (int i = 0; i < n-s-1; i++) {
                int j = i+s+1;
                long[] MinMax = MinAndMax(i, j);
                m[i][j] = MinMax[0];
                M[i][j] = MinMax[1];

            }
        }
//        System.out.println("m");
//        print(m);
//        System.out.println("M");
//        print(M);
        return M[0][n-1];
    }
    
    private static long[] MinAndMax(int i, int j){
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int index = 0;
        for (int k = i; k < j; k++) {
            char OP = op.get(k);
            long a = eval(M[i][k], M[k+1][j], OP);
            long b = eval(M[i][k], m[k+1][j], OP);
            long c = eval(m[i][k], M[k+1][j], OP);
            long d = eval(m[i][k], m[k+1][j], OP);
            min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
            max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
        }
        long[] MinMax = new long[2];
        MinMax[0]=min;
        MinMax[1]=max;
        return MinMax;
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
    
    private static void print(long[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

