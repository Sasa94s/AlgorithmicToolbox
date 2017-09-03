import java.util.Scanner;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int A = a.length;
        int B = b.length;
        int C = c.length;
//        int[][] res1 = new int[A+1][B+1];
//        int[][] res2 = new int[B+1][C+1];
//        int[][] res3 = new int[A+1][C+1];
        int[][][] res = new int[A+1][B+1][C+1];
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 1; k <= C; k++) {
                    if(a[i-1]==b[j-1] && b[j-1]==c[k-1]){
                        res[i][j][k] = res[i-1][j-1][k-1]+1;
                    } else {
                        res[i][j][k] = Math.max(res[i-1][j][k], Math.max(res[i][j-1][k], res[i][j][k-1]));
                    }
                }
            }
        }
//        for (int i = 1; i <= A; i++) {
//            for (int j = 1; j <= B; j++) {
//                if(a[i-1]==b[j-1]){
//                    res1[i][j] = res1[i-1][j-1]+1;
//                } else {
//                    res1[i][j] = Math.max(res1[i][j-1], res1[i-1][j]);
//                }
//                for (int k = 1; k <= C; k++) {
//                    if(b[j-1]==c[k-1]){
//                        res2[j][k] = res2[j-1][k-1]+1;
//                    } else {
//                        res2[j][k] = Math.max(res2[j][k-1], res2[j-1][k]);
//                    }
//                }
//            }
//            for (int j = 1; j <= C; j++) {
//                if(a[i-1]==c[j-1]){
//                    res3[i][j] = res3[i-1][j-1]+1;
//                } else {
//                    res3[i][j] = Math.max(res3[i][j-1], res3[i-1][j]);
//                }
//            }
//        }
//        System.out.println("res1");
//        print(res1);
//        System.out.println("----");
//        System.out.println("res2");
//        print(res2);
//        System.out.println("----");
//        System.out.println("res3");
//        print(res3);
//        System.out.println("----");
//        return Math.min(Math.min(res3[A][C], res2[B][C]), res1[A][B]);
        return res[A][B][C];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
    
    private static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

