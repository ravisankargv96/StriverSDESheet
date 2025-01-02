package Recursion;

import java.util.ArrayList;

public class SubsequenceGen {
    public void subsequence(int[]arr, int pos, ArrayList<Integer> state, ArrayList<ArrayList<Integer>> ans){

        if(pos == arr.length){
            ans.add(new ArrayList<Integer>(state));
            return;
        }

        //not considering state
        subsequence(arr,pos+1,state,ans);

        //considering state
        state.add(arr[pos]);
        subsequence(arr,pos+1,state,ans);
        state.remove(state.size()-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int pos = 0;
        ArrayList<Integer> state = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        SubsequenceGen obj = new SubsequenceGen();
        obj.subsequence(arr,pos,state,ans);

        //printing the subsequence;
        for(int i = 0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
