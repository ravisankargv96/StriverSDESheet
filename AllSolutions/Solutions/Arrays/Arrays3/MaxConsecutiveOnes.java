package Arrays3;

public class MaxConsecutiveOnes {

    /**
     * 1. Approach:
     * a. Whenever we encounter 1
     *      b. Increase the counter
     * c. encounter 0
     *      d. Update Tracker
     * T.C. O(N)
     * S.C. O(1)
     * */

    public static int findMaxConsecutiveOnes(int nums[]) {
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }
}
