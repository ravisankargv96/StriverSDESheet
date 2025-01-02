package LikedQuestion41_60.Permutations;

import java.util.*;

public class PermutationsMySol {

    public void swap(List<Integer> list,int i, int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public void permutation(int pos, List<Integer> state,
                            List<List<Integer>> res){

        if(pos == state.size()){
            res.add(new ArrayList<>(state));
            return;
        }

        for(int i = pos; i<state.size(); i++){
            swap(state,pos,i);
            permutation(pos+1,state,res);
            swap(state,pos,i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            state.add(nums[i]);
        }

        permutation(0,state,res);
        return res;
    }
}
