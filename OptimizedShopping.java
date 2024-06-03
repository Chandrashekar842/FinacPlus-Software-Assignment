import java.util.*;

public class OptimizedShopping {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfUnits = 6;
            int[] units = new int[numOfUnits];
            for(int i=0; i<numOfUnits; i++) {
                units[i] = sc.nextInt();
            }
            int limit = 100;
            double result = findOptimizedSet(units, limit);
            String formattedValue = String.format("%.1f", result);
            System.out.println("The average no of units used are " + formattedValue);
        }
    }

    public static double findOptimizedSet(int[] units, int limit) {
        int totalUnits = 0;
        for(int i=1; i<limit; i++) {
            int remaining = i;
            int count = 0;
            for(int j=units.length-1; j>=0; j--) {
                while(remaining >= units[j]) {
                    remaining -= units[j];
                    count++;
                }
            }
            totalUnits += count;
        }
        double avgUnitsUsed = (double) totalUnits/(limit-1);

        return avgUnitsUsed;
    }
}
