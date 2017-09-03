import java.util.Scanner;

public class Change {
    private static int getChange(int m, int n) {
        if(m/10>0) return getChange(m%10, n+m/10);
        if(m/5>0) return getChange(m%5, n+m/5);
        return n+m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = 0;
        System.out.println(getChange(m, n));

    }
}

