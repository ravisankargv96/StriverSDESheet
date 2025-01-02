package BinaryTree;
import java.util.*;

public class Solution {

    public int solution(int[] T) {
        int n = T.length;
        long totalTime = 0;
        long currentTime = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            currentTime++;
            pq.offer(currentTime + T[i]);
            totalTime += currentTime + T[i] - 1; // Adjusted to add the actual waiting time
        }

        while (!pq.isEmpty()) {
            long finishedTime = pq.poll();
            if (!pq.isEmpty()) {
                currentTime = Math.max(currentTime, finishedTime);
                totalTime += currentTime - (finishedTime - T[n - 1]); // Adjusted to subtract waiting time for previous items
            }
        }

        return (int) (totalTime % 1000000000);
    }

    public int solution_bard(int[] T) {
        int N = T.length;
        long totalWaitingTime = 0;
        long currentProcessingTime = 0;

        for (int i = 0; i < N; i++) {
            // Update current processing time by the minimum of remaining time and current item's processing time
            currentProcessingTime = Math.min(currentProcessingTime, T[i]);
            totalWaitingTime = (totalWaitingTime + currentProcessingTime) % 1_000_000_000; // Modulo operation

            // Add the remaining processing time for current item (if any)
            currentProcessingTime = Math.max(currentProcessingTime - T[i], 0);
        }

        return (int) totalWaitingTime;
    }

    public int solution_chatV2(int[] T) {
        // Sort the array T to process items in ascending order of time to make
        Arrays.sort(T);

        // Total time and current time initialized to 0
        long totalTime = 0;
        long currentTime = 0;

        // Iterate through each item in T
        for (int i = 0; i < T.length; i++) {
            // Add the time taken to make the current item
            currentTime += T[i];
            // Add the current time to the total time
            totalTime += currentTime;
        }

        // Return the total time modulo 10^9
        return (int) (totalTime % 1000000000);
    }

    public int solution_Cv3(int[] T) {
        // Sort the array T to process items in ascending order of time to make
        Arrays.sort(T);

        // Total time and current time initialized to 0
        long totalTime = 0;
        long currentTime = 0;

        // Iterate through each item in T
        for (int i = 0; i < T.length; i++) {
            // Add the current time to the total time
            totalTime += currentTime;
            // Increment the current time by the time taken to make the current item
            currentTime += T[i];
        }

        // Add the last currentTime to totalTime since it's not added inside the loop
        totalTime += currentTime;

        // Return the total time modulo 10^9
        return (int) (totalTime % 1000000000);
    }

    public int solution_chat(int[] T) {
        int n = T.length;
        long totalTime = 0; // Initialize total time
        long currentTime = 0; // Initialize current time
        PriorityQueue<Long> pq = new PriorityQueue<>(); // Priority queue to keep track of completion times

        for (int i = 0; i < n; i++) {
            currentTime++; // Increment current time
            pq.offer(currentTime + T[i]); // Add completion time to the priority queue
            totalTime += currentTime; // Update total time
        }

        while (!pq.isEmpty()) {
            long finishedTime = pq.poll(); // Get the finished time of an item
            if (!pq.isEmpty()) {
                currentTime = Math.max(currentTime, finishedTime); // Update current time
                totalTime += currentTime - (finishedTime - T[n - 1]); // Update total time
            }
        }

        return (int) (totalTime % 1000000000); // Return total time modulo 10^9
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 1, 2})); // Output: 13
        System.out.println(solution.solution(new int[]{1, 2, 3, 4})); // Output: 24
        System.out.println(solution.solution(new int[]{7, 7, 7})); // Output: 60
        System.out.println(solution.solution(new int[]{10000})); // Output: 10000
    }
}
