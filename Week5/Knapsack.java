import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }
    static int dynamicWeight(int W, int[] w) {
        //write you code here
        int n = w.length;
        int res[][] = new int[n+1][W+1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 1; j <= W; j++) {
                
                if((w[i-1])<=j){
                    res[i][j] = Math.max(w[i-1]+res[i-1][j-w[i-1]], res[i-1][j]);
//                    System.out.println(j-w[i-1]+" i="+i+" j="+j+" w[i-1]="+w[i-1]+" res="+res[i][j]);
                } else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
//        System.out.println();
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res[i].length; j++) {
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }
        return res[n][W];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
//        System.out.println(optimalWeight(W, w));
        System.out.println(dynamicWeight(W, w));
    }
}

