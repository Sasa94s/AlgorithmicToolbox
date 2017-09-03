import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static Random random = new Random();
    private static int[] a;
    
    private static int[] partition3(int l, int r, int pivot) {
      //write your code here
      
      
      int m1 = l;
      int m2 = r;
      int x = a[pivot];
      int i = l;
      
      while(i<=m2){
          if(x>a[i]){
              exchange(m1++, i++);
          } else if(x<a[i]){
              exchange(m2--, i);
          } else {
              i++;
          }
      }
        //exchange(m1, m2);
      int[] m = {m1,m2};
      return m;
    }

    private static int partition2(int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                exchange(i, j);
            }
        }
        //exchange(l, j);
        return j;
    }
    
    private static void exchange(int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void randomizedQuickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
//        int t = a[l];
//        a[l] = a[k];
//        a[k] = t;
        //use partition3
        int[] m = partition3(l, r, k);
        randomizedQuickSort(l, m[0] - 1);
        randomizedQuickSort(m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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
    }
}

