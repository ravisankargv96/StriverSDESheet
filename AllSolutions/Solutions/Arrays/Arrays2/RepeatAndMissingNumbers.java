package Arrays2;

import java.util.*;

public class RepeatAndMissingNumbers {

    /**
     * Ques: nums are 1-N out of that one is missing & one is repeated twice.
     * 1. Sorting
     * T.C. O(NlogN)
     * S.C. O(NlogN)
     *
     * 2. Using Extra Array (Similar to HashMap) - similar like countSort (sol1)
     * 3. Using -veFlagArray
     * T.C. O(N)
     * S.C. O(1)
     * 4. Estimated Sum (sol2)
     * 5. Using Xor Approach (Optimal)
     * T.C. O(N)
     * S.C. O(1)
     * */

    // 1. Sorting
    public static int[] findRepeatMissingSol1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int repeat = 0;
        int missing = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                repeat = nums[i];
            } else if (nums[i] + 1 != nums[i + 1]) {
                missing = nums[i] + 1;
            }
        }

        // Edge case handling for the missing number at the end
        if (nums[n - 1] != n) {
            missing = n;
        }

        return new int[]{repeat, missing};
    }

    // 2. Using Extra Array
    public static ArrayList<Integer> findRepeatMissingSol2(List<Integer> nums) {
        int n = nums.size();

        int[] arr = new int[n+1]; // initializing the arr nums with 0 of size n+1.

        ArrayList<Integer> ans = new ArrayList<>();              // initializing the answer  nums .

        for (int i = 0; i < nums.size(); i++) {
            arr[nums.get(i)]++;
        }

        for (int i = 1; i <= nums.size(); i++) {
            if (arr[i] == 0 || arr[i] > 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    //3. Using -veFlagArray

    public static int[] findRepeatMissingSol3(int[] nums) {
        int n = nums.length;
        int repeat = 0;
        int missing = 0;

        // Mark the presence of elements using negative values
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                repeat = Math.abs(nums[i]);
            }
        }

        // Find the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{repeat, missing};
    }

    //4. EstimateSum approach
    /**
     * R - M = nums - estimatedNums
     * R^2 - M^2 = nums^2 - estimatedNums^2
     * with these we can find R & M
     * Note: We should take care of Overflows.
     * rewrite the code later without using Formulae
     * */

    public static ArrayList<Integer> findRepeatMissingSol4(List<Integer> nums) {
        long len = nums.size();

        long S = (len * (len + 1) ) / 2;
        long P = (len * (len + 1) * (2 * len + 1) ) / 6;
        long missingNumber = 0, repeating = 0;

        for (int i = 0; i < nums.size(); i++) {
            S -= (long)nums.get(i);
            P -= (long)nums.get(i) * (long)nums.get(i);
        }

        missingNumber = (S + P / S) / 2;

        repeating = missingNumber - S;

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int)repeating);
        ans.add((int)missingNumber);

        return ans;
    }

    //5. Xor Approach
    //
    public static void findRepeatMissingSol5(int arr[], int n)
    {

        int[] ans = new int[2];

        int xor1 = 0;
        int set_bit_no = 0;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < n; i++)
            xor1 = xor1 ^ arr[i];

        //estimatedNums
        for (int i = 0; i < n; i++)
            xor1 = xor1 ^ (i+1);

        // 31 is signbit, so iterating from 0 to 30
        for(int i = 0; i<31; i++){
            if((xor1 & 1<<i) > 0){
                set_bit_no = i;
                break;
            }
        }


        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1<<set_bit_no) > 0)
                num1 = num1 ^ arr[i];
            else
                num2 = num2 ^ arr[i];
        }

        for (int i = 0; i < n; i++) {

            if ( ((i+1) & set_bit_no) > 0)
                num1 = num1 ^ i;
            else
                num2 = num2 ^ i;
        }

        //results saved in ans array
        for(int i = 0; i < n; i++){
            if(num1 == arr[i]){
                ans[0] = num1; // repeated
                ans[1] = num2; // ismissing
            }

            if(num2 == arr[i]){
                ans[0] = num2; // repeated
                ans[1] = num1; // ismissing
            }
        }
    }

    public static void main(String[] args) {

    }
}
