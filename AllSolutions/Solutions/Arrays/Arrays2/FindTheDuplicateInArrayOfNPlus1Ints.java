package Arrays2;

import java.util.*;

public class FindTheDuplicateInArrayOfNPlus1Ints {

    /**
     * 1. Sorting
     * T.C. O(NlogN)
     * S.C. O(NlogN)
     * 2. HashMap
     * T.C. O(N)
     * S.C. O(N)
     * 3. Using Extra Array (Similar to HashMap) - complete the code
     * 4. Using -veFlagArray - complete the code
     * T.C. O(N)
     * S.C. O(1)
     * 5. Using Xor Approach
     * T.C. O(N)
     * S.C. O(1)
     * */

    //1. Sorting
    public static int findDuplicateSol1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }

    //2. HashMap
    public static int findDuplicateSol2(int[] arr) {
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                return arr[i];
            }
        }
        return 0;
    }

    //3. Using Extra Array (Similar to HashMap)
    public static int findDuplicateSol3(int[] nums) {
        int[] count = new int[nums.length];

        for (int num : nums) {
            if (count[num] > 0) {
                return num;
            }
            count[num]++;
        }

        // If no duplicate is found
        return -1;
    }

    //4. Using -veFlagArray
    public static int findDuplicateSol4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return Math.abs(nums[i]);
            }
            nums[index] = -nums[index];
        }

        // If no duplicate is found
        return -1;
    }

    //5. Xor
    // cumilativeXor of ActualNums^EstimatedNums
    public static int findDuplicate(int[] nums) {

        int ele = 0;
        int n = nums.length;

        for(int i = 0; i<n; i++){
            ele ^= nums[i];
            ele ^= (i+1); //estimated Number
        }
        return ele;
    }

    public static void main(String args[]) {
        int arr[] = {1,3,4,2,3};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

}
