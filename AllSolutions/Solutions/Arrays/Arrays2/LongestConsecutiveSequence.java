package Arrays2;

import java.util.*;

public class LongestConsecutiveSequence {

    /**
     * 1. BruteForce: Sorting
     * T.C. O(N*logN)
     * S.C. O(N*logN)
     * 2. using HashSet
     * T.C. O(N)
     * S.C. O(N)
     * */

    //BruteForce : Sorting
    public static int longestConsecutiveSol1(int[] nums) {

        if(nums.length == 0 || nums == null){
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;
        int prev = nums[0];
        int cur = 1;

        for(int i = 1;i < nums.length;i++){
            if(nums[i] == prev+1){
                cur++;
            }
            else if(nums[i] != prev){
                cur = 1;
            }
            prev = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    //Optimal Approach : HashSet
    public static int longestConsecutive(int[] nums) {

        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int maxStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int seqGen = num;
                int count = 1;

                while (hashSet.contains(seqGen + 1)) {
                    seqGen += 1;
                    count += 1;
                }

                maxStreak = Math.max(maxStreak, count);
            }
        }

        return maxStreak;
    }

    public static void main(String args[])
    {
        int arr[]={100,200,1,2,3,4};
        int lon=longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is "+lon);

    }
}
