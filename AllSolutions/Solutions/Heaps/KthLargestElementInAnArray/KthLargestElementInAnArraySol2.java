package LeetCode_copies.SubmittedCodes1_20.KthLargestElementInAnArray;

import java.util.*;

public class KthLargestElementInAnArraySol2 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        for(int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }

}
