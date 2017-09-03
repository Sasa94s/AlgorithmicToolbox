import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LargestNumber {
    static List<String> numbers = new ArrayList<>();
    static int number;
    /*
    3 909 9 90
    3 9 909 90
    3 90 909 9
    3 90 9 909
    
    Desired Output: 990990
    */
    private static String largestNumber() {
        String res = "";
        while (true) {
            char max = numbers.get(0).charAt(0);
            int index = 0;
            for (int j = 1; j < numbers.size(); j++) {
                char c = numbers.get(j).charAt(0);
                if(max<c){
                    max = c;
                    index = j;
                } else if(max == c & j!=index){
                    String a = numbers.get(index);
                    String b = numbers.get(j);
                    
                    Integer x1 = new Integer(a+b);
                    Integer x2 = new Integer(b+a);
                    
                    if(x1.compareTo(x2)==-1){
                        index = j;
                    }
                }
            }
            res += numbers.remove(index);
            if(numbers.size()==0) break;
        }
        return res;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            numbers.add(scanner.next());
        }
        System.out.println(largestNumber());
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