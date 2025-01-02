package Solutions.codingPatterns.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NaryTree {
    public void naryTree(int[] num, int pos, List<int[]> ans){

        if(pos == num.length){
            ans.add(num.clone());
            return;
        }

        // At this point we'll call N (i.e. [pos,...,num.length-1])
        // function calls.

        for(int i = pos; i<num.length; i++){
            //do something
            naryTree(num,pos+1,ans);
            // perform reverse.
        }

    }

    public void swap(int[] num, int i, int j){
        int copy = num[i];
        num[i] = num[j];
        num[j] = copy;
    }

    public void permute(int[] num, int pos, ArrayList<int[]> ans){

        if(pos == num.length){
            ans.add(num.clone());
            return;
        }

        for(int i = pos; i< num.length; i++){
            swap(num,pos,i);
            permute(num,pos+1,ans);
            swap(num,pos,i);
        }
    }



}
