package Arrays3;

import java.util.HashMap;

public class LargestSubarraywithKSum {

    /**
     * 1. OptimalSolution : prefixSum+cumilativeHashMap -> helps in getting Array also
     *  a. Generating a prefixSum
     *  b. Tracking if any kSum is encountered or not.
     *  c. Applying cumilativeHashMap for that prefixSum, just like TwoSum approach,
     *  Modify the code.
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
