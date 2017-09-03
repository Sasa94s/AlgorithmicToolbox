import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class PointsAndSegments {
    private static Random random = new Random();
    private static int count;
    private static Element[] all;
    private static Element[] a;

    private static int number;

    
    private static int[] fastCountSegments(Element[] a, int points) {
        int[] cnt = new int[points];
        //write your code here
        Arrays.sort(a, new Comparator<Element>(){

            @Override
            public int compare(Element o1, Element o2) {
                return (int) (o1.value == o2.value ? o1.label - o2.label : o1.value-o2.value);
            }

            
            
        });
        for (int i = 0; i < a.length; i++) {
            if(a[i].label == 'l'){
                ++count;
            } else if(a[i].label == 'r'){
                --count;
            }
            if(a[i].label == 'p'){
                
                cnt[a[i].id] = count;
            }
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        UP:for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
    
    
    private static void merge(int lo, int hi){
        if(lo>=hi) return;
        int middle = lo + (hi - lo)/2;

        merge(lo, middle);
        merge(middle + 1, hi);
        mergeSort(lo, middle, hi);
    }
    
    private static void mergeSort(int lo, int mid, int hi){
        a = new Element[number];
        for (int i = 0; i < number; i++) {
            a[i] = new Element(all[i]);
        }
        
        int i = lo;
        int j = mid + 1;
        int k = lo;
        
        while(i<=mid && j<=hi){
            if(a[i].value == a[j].value){
//                if(a[i].label == 'p' && a[j].label == 'l'){
//                    all[k] = new Element(a[j]);
//                    ++j;
//                }
//                else if(a[i].label == 'r' && a[j].label == 'p'){
//                    all[k] = new Element(a[i]);
//                    ++i;
//                }
                if(a[i].label < a[j].label){
                    all[k] = a[i];
                    ++i;
                } else {
                    all[k] = a[j];
                    ++j;
                }
            } else if(a[i].value < a[j].value){
                all[k] = a[i];
                ++i;
            } else {
                all[k] = a[j];
                ++j;
            }
            ++k;
        }
        
        while(i<=mid){
            all[k] = a[i];
            ++i;
            ++k;
        }
    }
    
    private static int[] partition3(Element[] a, int l, int r, int pivot) {

        int m1 = l;
        int m2 = r;
        long x = a[pivot].value;
        int i = l;

        while(i<=m2){
            if(x>a[i].value){
                exchange(a, m1++, i++);
            } else if(x<a[i].value){
                exchange(a, m2--, i);
            } else {
                if(a[i].label == 'p' && a[pivot].label == 'l'){
                    exchange(a, pivot, i);
                }
                else if(a[i].label == 'r' && a[pivot].label == 'p'){
                    exchange(a, pivot, i);
                }
                i++;
            }
        }
        int[] m = {m1,m2};
        return m;
    }
    
    private static void exchange(Element[] a, int i, int j){
        Element t = new Element(a[i]);
        a[i] = a[j];
        a[j] = new Element(t);
    }
    private static void randomizedQuickSort(Element[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int[] m = partition3(a, l, r, k);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    static class Element{
        long value;
        char label;
        int id;
        Element(int id, char label, long value){
            this.label = label;
            this.value = value;
            this.id = id;
        }
        Element(Element a){
            this.label = a.label;
            this.value = a.value;
            this.id = a.id;
        }
        void print(){
            System.out.println("Element "+id+": Value is "+this.value+", Label is "+this.label);
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        number = m+2*n;
        all = new Element[number];
        for (int i = 0; i < n; i++) {
            all[2*i] = new Element(i, 'l', scanner.nextInt());
            all[2*i+1] = new Element(i, 'r', scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            all[2*n+i] = new Element(i, 'p', scanner.nextInt());
        }
        
//        randomizedQuickSort(all, 0, number - 1);
//        merge(0, number - 1);

        //use fastCountSegments
        int[] cnt = fastCountSegments(all, m);
//        for (int i = 0; i < number; i++) {
//            all[i].print();
//        }

//        int[] cnt2 = naiveCountSegments(start, end, points);
//        boolean ok = true;
//        for (int i = 0; i < cnt.length; i++) {
//            if(cnt[i] != cnt2[i]) {
//                ok = false;
//                break;
//            }
//        }
//        if(ok) {
//            System.out.print("OK! Output: ");
//        } else {
//            System.out.print("Wrong answer! Correct output: ");
//            for (int x : cnt2) {
//            System.out.print(x + " ");
//        }
//            System.out.print(" Your output: ");
//        }
        for (int x : cnt) {
            System.out.print(x + " ");
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

