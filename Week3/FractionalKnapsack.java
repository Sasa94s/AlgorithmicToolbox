import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    private static int number;
    private static int[] values;
    private static int[] weights;
    private static double[] ratios;
    private static double[] helper;
    
    public static void sort() {
        ratios = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            ratios[i] = (double) values[i] / weights[i];
        }
        number = values.length;
        mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }
    
    private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        helper = Arrays.copyOf(ratios, ratios.length);
        int[] valuesCopy = Arrays.copyOf(values, values.length);
        int[] weighsCopy = Arrays.copyOf(weights, weights.length);
        
        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] >= helper[j]) {
                ratios[k] = helper[i];
                values[k] = valuesCopy[i];
                weights[k] = weighsCopy[i];
                i++;
            } else {
                ratios[k] = helper[j];
                values[k] = valuesCopy[j];
                weights[k] = weighsCopy[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            ratios[k] = helper[i];
            values[k] = valuesCopy[i];
            weights[k] = weighsCopy[i];
            k++;
            i++;
        }

    }
    
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        for (int i = 0; i < ratios.length; ++i) {
            if(capacity==0) return value;
            if(capacity < weights[i]) {
                value+=(capacity*ratios[i]);
                capacity=0;
            }
            else {
                value+=(ratios[i]*weights[i]);
                capacity -= weights[i];
            }
        }
        return value;
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        values = new int[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        sort();
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
