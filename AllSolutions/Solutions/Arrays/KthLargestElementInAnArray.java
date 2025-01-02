package LeetCode60Questions.Arrays;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public void swap(int[] nums,int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    public int findKthLargestSol2(int[] nums, int k) {
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