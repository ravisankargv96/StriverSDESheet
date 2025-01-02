package LeetCode60Questions.Arrays;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length < 3){
            Collections.emptyList();
        }

        Arrays.sort(nums);

        for(int i = 0; i<nums.length - 2; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int low = i+1;
            int high = nums.length-1;

            while(low < high){
                if(nums[low] + nums[high] < -nums[i]){
                    low++;
                } else if(nums[low] + nums[high] > -nums[i]){
                    high--;
                } else{
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low+1 < nums.length && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(high-1 >= 0 && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                }
            }
        }

        return res;

    }
}
