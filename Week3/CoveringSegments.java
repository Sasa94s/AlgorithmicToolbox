import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {
    private static int number;
    private static Segment[] segments;
    private static Segment[] numbers;

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        number = segments.length;
        sort(segments);
        List<Integer> points = new ArrayList<>();
//        for (int i = 0; i < number; i++) {
//            System.out.println(segments[i].start+" "+segments[i].end);
//        }
        int point=segments[0].end;
        points.add(point);
        for (int i = 1; i < number; i++) {
            if(point<segments[i].start || point>segments[i].end){
                point = segments[i].end;
                points.add(point);
            }
        }
        
        return points;
    }
    
    private static class Segment {
        int start, end;
        
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    

    public static void sort(Segment[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2].end;

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i].end < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j].end > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i].end;
        numbers[i].end = numbers[j].end;
        numbers[j].end = temp;
        temp = numbers[i].start;
        numbers[i].start = numbers[j].start;
        numbers[j].start = temp;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
