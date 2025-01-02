package Arrays3;

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {
    /**
     * 1. BruteForce : forEach SubArray generating prefixSum
     * T.C. O(N^2)
     * S.C. O(1)
     * 2. OptimalSolution : prefixSum+cumilativeHashMap -> helps in getting Array also
     *  a. Generating a prefixSum
     *  b. Tracking if any zeroSum is encountered or not.
     *  c. Applying cumilativeHashMap for that prefixSum
     * */

    /**
     * 1. BruteForce
     * */
    public static int maxLenSol1(int[] a){
        int  max = 0;
        for(int i = 0; i < a.length; ++i){
            int sum = 0;
            for(int j = i; j < a.length; ++j){
                sum += a[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    /**
     * 2. OptimalApproach
     * */

    public int maxLen(int A[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for(int i = 0;i<n;i++) {

            sum += A[i];

            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(mpp.containsKey(sum)) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void main(String args[])
    {
        int a[] = {9, -3, 3, -1, 6, -5};
        LargestSubArrayWithZeroSum sol = new LargestSubArrayWithZeroSum();
        System.out.println(sol.maxLen(a,a.length));
    }
}
