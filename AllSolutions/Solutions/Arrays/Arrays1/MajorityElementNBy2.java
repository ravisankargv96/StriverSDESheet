package Solutions.Arrays.Arrays1;

import java.util.*;

//Memorize the moore's Algo
public class MajorityElementNBy2 {

    //BruteForce: T.C. O(N^2) S.C. O(1)
    public int majorityElementSol1(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i])
                    cnt++;
            }

            if (cnt > (n / 2))
                return nums[i];
        }

        return Integer.MIN_VALUE;
    }

    //Optimal: T.C. O(N) S.C. O(N)
    public int majorityElementSol2(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    //Moore's Algo: T.C. O(N) S.C. O(1)
    public int majorityElement(int[] nums) {
        //if nums definitely has majority in it.

        int n = nums.length;
        int count = 0;
        int winner = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(count == 0){
                winner = nums[i];
                count++;
            } else if(nums[i] == winner){
                count++;
            } else{
                count--;
            }
        }

        if(count > 0){
            return winner;
        }

        return Integer.MAX_VALUE;
    }
}
