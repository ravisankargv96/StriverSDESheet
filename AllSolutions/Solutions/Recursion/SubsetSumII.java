package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    public void findSubsets(int[] nums, int pos, List<Integer> state, List<List<Integer>> ans){
        ans.add(new ArrayList<>(state));

        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i-1]){
                continue;
            }

            //considering ith element
            state.add(nums[i]);
            findSubsets(nums,pos+1,state,ans);
            state.remove(state.size()-1);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,2};
        //sort the arr

        Arrays.sort(arr);

        SubsetSumII obj = new SubsetSumII();

        int pos = 0;
        List<Integer> state = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        obj.findSubsets(arr,pos,state,ans);

        System.out.println(ans);
    }
}
