package LeetCode_copies.SubmittedCodes1_20.MedianOfTwoSortedArrays;

/*
Approach 1: Brute Force TC: O(n) SC: O(n)
    1. We Merge The Two Sorted Array (Basic Merging Method Of Merge Sort, With 2 Pointers.
    2. We Find The Median Of The New Array.
*/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int numsPointer = 0;
        int[] nums = new int[nums1.length + nums2.length];

        while(nums1Pointer < nums1.length && nums2Pointer < nums2.length){
            if(nums1[nums1Pointer] < nums2[nums2Pointer]){
                nums[numsPointer] = nums1[nums1Pointer];
                nums1Pointer++;
            }else{
                nums[numsPointer] = nums2[nums2Pointer];
                nums2Pointer++;
            }
            numsPointer++;
        }

        while(nums1Pointer<nums1.length){
            nums[numsPointer] = nums1[nums1Pointer];
            numsPointer++;
            nums1Pointer++;
        }

        while(nums2Pointer<nums2.length){
            nums[numsPointer] = nums2[nums2Pointer];
            numsPointer++;
            nums2Pointer++;
        }

        if(nums.length%2 == 0){
            double median = (double)(nums[nums.length/2] + nums[(nums.length/2) - 1])/2;
            return median;
        }else{
            double median = nums[(nums.length-1)/2];
            return median;
        }

    }
}



