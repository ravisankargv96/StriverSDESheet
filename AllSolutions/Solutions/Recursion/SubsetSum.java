package Recursion;

import java.util.ArrayList;

public class SubsetSum {
    //considering SubsequenceGen code and reusing that code.

    public void subsetSum(int[] arr, int pos, int sum, ArrayList<Integer> ans){

        if(pos == arr.length){
            ans.add(sum);
            return;
        }

        //not considering
        subsetSum(arr,pos+1, sum, ans);

        //considering
        subsetSum(arr,pos+1, sum+arr[pos], ans);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        int pos = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        SubsetSum obj = new SubsetSum();
        obj.subsetSum(arr, pos, sum, ans);

        //printing the ans
        for(int value : ans){
            System.out.println(value);
        }
    }
}
