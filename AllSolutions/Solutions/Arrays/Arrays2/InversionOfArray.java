package Arrays2;

public class InversionOfArray {

    /*
    * 1. BruteForce T.C. O(N^2) S.C. O(1)
    * 2. MergeSort T.C. O(N*logN) S.C. O(N)
    * */

    // 1. BruteForce
    public static int countInversionsSol1(int[] nums) {
        int inversions = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    inversions++;
                }
            }
        }

        return inversions;
    }


    //2. MergeSort
    public static int countInversionsSol2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int[] temp, int left, int right) {
        int inversions = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            inversions += mergeSort(nums, temp, left, mid);
            inversions += mergeSort(nums, temp, mid + 1, right);
            inversions += merge(nums, temp, left, mid, right);
        }

        return inversions;
    }

    private static int merge(int[] nums, int[] temp, int left, int mid, int right) {
        int inversions = 0;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                inversions += mid - i + 1; // Count the inversions
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int m = left; m <= right; m++) {
            nums[m] = temp[m];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5}; // Example array
        int inversions = countInversionsSol2(nums);
        System.out.println("Number of inversions: " + inversions);
    }
}
