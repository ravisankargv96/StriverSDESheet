package LeetCode60Questions.Recursion;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //MySolution
    public void swapMySol(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public void permutationMySol(int pos, List<Integer> state,
                                 List<List<Integer>> res){

        if(pos == state.size()){
            res.add(new ArrayList<>(state));
            return;
        }

        for(int i = pos; i<state.size(); i++){
            swapMySol(state,pos,i);
            permutationMySol(pos+1,state,res);
            swapMySol(state,pos,i);
        }
    }

    public List<List<Integer>> permuteMySol(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            state.add(nums[i]);
        }

        permutationMySol(0,state,res);
        return res;
    }
}
