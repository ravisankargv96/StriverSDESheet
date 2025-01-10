package LeetCode_copies.SubmittedCodes1_20.MedianOfTwoSortedArrays;

/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.
Memory Usage: 43 MB, less than 98.54% of Java online submissions for Median of Two Sorted Arrays.

Approach 2: Optimized TC: O(logn) SC: O(1) Solution Using Binary Search
    1. We Use Binary Search To Create Partitions In Both The Sorted Arrays
    2. We Check If The Left And Rights Of The Partition Satisfies The Conditions Which Are Written In Comments Below.
*/
public class MedianOfTwoSortedArraysSol2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //Calling The Function Again With nums1 As The Smaller Size Array
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        // Applying Binary Search To The 2 Arrays
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int start = 0;
        int end = nums1Length;

        while(start <= end){

            int partition1 = start + (end-start)/2; // Mid Partition In The Smaller Size Array
            int partition2 = (nums1Length + nums2Length + 1)/2 - partition1; // Mid Partition In The Larger Size Array

            // Taking Left And Right Values Of The Partition Of Both The Arrays And Cross Checking Them
            int left1 = (partition1 > 0)? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int left2 = (partition2 > 0)? nums2[partition2 - 1] : Integer.MIN_VALUE;

            int right1 = (partition1 < nums1Length)? nums1[partition1] : Integer.MAX_VALUE;
            int right2 = (partition2 < nums2Length)? nums2[partition2] : Integer.MAX_VALUE;

            /*
            If Left Value Of The First Array Is Smaller Than Right Value Of The Second Array
                                               And
            Left Value Of The Second Array Is Smaller Than Right Value Of The First Array
                                              Then
            We Check If The Size Of The Sum Of Length Of Both Arrays Is Odd Or Even Because
            If Odd, We Return The Max Of Left1 And Left2, And If Even We Return The Average
            Of (Max(left1, left2) + Min(right1, right2)) / 2.0 as per the Average Formula.
            */
            if(left1 <= right2 && left2 <= right1){
                if((nums1Length + nums2Length) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else{
                    return Math.max(left1, left2);
                }
            }
            else if(left1 > right2){    // Base Binary Search Condition
                end = partition1 - 1;
            }
            else{
                start = partition1 + 1; // Base Binary Search Condition
            }

        }

        // Default Return Input
        return 0.0;

    }
}
