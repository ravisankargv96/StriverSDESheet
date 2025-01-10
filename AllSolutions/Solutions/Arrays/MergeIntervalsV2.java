package Solutions.Arrays;

import java.util.*;

public class MergeIntervalsV2 {
    public boolean isOverlap(int[] interval1, int[] interval2){
        if(interval1[1] < interval2[0] || interval2[1] < interval2[0]){
            return false;
        }
        return true;
    }

    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> ans = new ArrayList<>();

        //Throwing an error & don't know how to resolve this
        /*
        Arrays.sort(intervals, new Comparator<int[]>(){

            public int compare(final int[] arr1, final int[] arr2){

                if(arr1[0] < arr2[0] ||
                   (arr1[0] == arr2[0] && arr1[0] < arr2[0])){
                    return -1;
                }
                return 1;
            }
        });
        */


        Arrays.sort(intervals, (arr1,arr2)-> Integer.compare(arr1[0],arr2[0]));


        // Algo after sorting
        int[] prevInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++){

            if(isOverlap(prevInterval,intervals[i])){

                prevInterval[1] = Math.max(prevInterval[1],intervals[i][1]);

            } else{
                ans.add(prevInterval.clone());
                prevInterval = intervals[i];
            }
        }

        ans.add(prevInterval.clone());

        return ans.toArray(new int[ans.size()][]);

    }
}
