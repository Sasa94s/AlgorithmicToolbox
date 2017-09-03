import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] z1 = new int[a.length], z2 = new int[b.length];
        int c1=0,c2=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==0) {
                z1[c1++]=i;
            }
            if(b[i]==0) {
                z2[c2++]=i;
            }
        }
        int n=0;
        if(c1>c2) n = c2;
        else n = c1;
        for (int i = 0; i < n; i++) {
            shift(a, a[z1[i]]);
            shift(b, a[z2[i]]);
        }
        long result = 0;
        for (int i = 0; i < a.length-n; i++) {
            result += (long) a[i] * (long) b[i];
        }
        return result;
    }
    
    private static void shift(int[] a, int startIndex){
        for (int i = startIndex; i < a.length-1; ++i) {
            a[i]=a[i+1];
        }
    }
    
    public static StringBuilder generateCases(StringBuilder res, int a, int b){
        if(a==b) return res;
        Random r = new Random();
        int n = r.nextInt(10^3);
        res.append(n+"\n");
        if(n==0) return generateCases(res.append("\n"), ++a, b);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                res.append(r.nextInt(2*(int)Math.pow(10, 5) + 1) - (int)Math.pow(10, 5));
                res.append(" ");
            }
            res.append("\n");
        }
        res.append("\n");
        return generateCases(res, ++a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

