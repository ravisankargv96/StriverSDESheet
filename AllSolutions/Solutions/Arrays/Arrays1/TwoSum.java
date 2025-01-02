package Solutions.Arrays.Arrays1;

import java.util.*;

//Memorize Cumilative HashMap & TwoPointer approach it has several applications
public class TwoSum {

    /**
     * 1. BruteForce
     * 2. Sorting + TwoPointer
     * 3. Cumilative HashMap
     * */

    /**
     * 1. BruteForce Solution with TC: O(n^2) SC: O(1)
     * */
    public int[] twoSum(ArrayList<Integer> nums, int target){

        int[] res = new int[2];
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                if (nums.get(i) + nums.get(j) == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //2. Sorting + Two Pointer T.C. O(nlogn) & S.C. O(1)

    public static void TwoPointer(int[] nums, int target)
    {
        // sort the array in ascending order
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        while (low < high)
        {
            // sum found
            if (nums[low] + nums[high] == target)
            {
                System.out.printf("Pair found (%d, %d)", nums[low], nums[high]);
                return;
            }



            if (nums[low] + nums[high] < target) {
                low++;
            }
            else {
                high--;
            }

            while (low < high && nums[low] == nums[low + 1]) low++;
            while (low < high && nums[high] == nums[high - 1]) high--;
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

    // Optimized Solution: T.C. O(n) & S.C. O(n) using
    // 3. Cumilative HashMap

    public static void hashMap(int[] nums, int target)
    {
        // create an empty HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
            // check if pair (nums[i], target-nums[i]) exists

            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
                System.out.printf("Pair found (%d, %d)",
                        nums[map.get(target - nums[i])], nums[i]);
                return;
            }

            // store index of the current element in the map
            map.put(nums[i], i);
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

}
