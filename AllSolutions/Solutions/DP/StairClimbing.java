package Solutions.DP;

import java.util.*;

// check these codes later

public class StairClimbing {

    // Recursive approach
    public static int countWaysRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return countWaysRecursive(n - 1) + countWaysRecursive(n - 2);
    }

    // Memoization approach
    public static int countWaysMemoize(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, countWaysMemoize(n - 1, memo) + countWaysMemoize(n - 2, memo));
        }
        return memo.get(n);
    }

    // Tabulation approach
    public static int countWaysTabulation(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }

    // Space-optimized Tabulation approach
    public static int countWaysSpaceOptimizedTabulation(int n) {
        if (n <= 1) {
            return 1;
        }

        int a = 1, b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursive: " + countWaysRecursive(n));

        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println("Memoization: " + countWaysMemoize(n, memo));

        System.out.println("Tabulation: " + countWaysTabulation(n));
        System.out.println("Space-optimized Tabulation: " + countWaysSpaceOptimizedTabulation(n));
    }
}

