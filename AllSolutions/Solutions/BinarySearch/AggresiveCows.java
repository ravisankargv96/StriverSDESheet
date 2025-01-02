package BinarySearch;

import java.util.Arrays;

public class AggresiveCows {

    /**
     * BruteForce Approach:
     * Optimal Approach: BinarySearch (memorize the approach)
     * find the search Space at
     * */

    boolean isCompatible(int[] inp, int dist, int cows){
        int n = inp.length;
        int lastPos = inp[0];

        cows--;

        for(int i = 1; i < n; i++){
            if(inp[i] - lastPos >= dist){
                cows--;
                if(cows == 0){
                    return true;
                }
                lastPos = inp[i];
            }
        }

        return false;
    }

    //complete the BinarySearch Code.

    public static void main(String[] args) {
        int n = 5, m = 3;

        int[] inp = new int[]{1,2,8,4,9};
        Arrays.sort(inp);


        AggresiveCows obj = new AggresiveCows();

        int maxD = inp[n - 1] - inp[0];
        int ans = Integer.MIN_VALUE;
        for (int d = 1; d <= maxD; d++) {
            boolean possible = obj.isCompatible(inp, d, m);
            if (possible) {
                ans = Math.max(ans, d);
            }
        }
        System.out.println("The largest minimum distance is " + ans);
    }
}
