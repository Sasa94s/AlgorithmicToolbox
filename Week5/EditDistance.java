import java.util.Scanner;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int S = s.length();
    int T = t.length();
    int[][] res = new int[S+1][T+1];
    for (int i = 1; i <= S; i++) {
        res[i][0] = res[i-1][0]+1;
    }
    for (int i = 1; i <= T; i++) {
        res[0][i] = res[0][i-1]+1;
    }
    for (int i = 1; i <= S; i++) {
        for (int j = 1; j <= T; j++) {
            int d = res[i-1][j-1];
            int indel = Math.min(res[i][j-1]+1, res[i-1][j]+1);
            res[i][j] = s.charAt(i-1) == t.charAt(j-1) ? Math.min(indel, d) : Math.min(indel, d+1);
        }
    }
//    print(res);
    return res[S][T];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
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
