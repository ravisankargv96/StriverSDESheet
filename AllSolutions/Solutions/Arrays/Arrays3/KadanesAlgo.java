package Arrays3;

//Purely Algo based question.
// take the insites while explaining the algo clearly.

public class KadanesAlgo {

    /** 1. BruteForce: forEach SubArray (Sum of SubArray) solution
     * T.C. O(n^3)
     * S.C. O(1)
     * 2. forEach SubArray generate prefix Sum Solution
     * T.C. O(n^2)
     * S.C. O(1)
     * 3. Kadane's Algo
     * T.C. O(n)
     * S.C. O(1)
     * 4. Extended Version Kadane's Algo returning the maxArray
     * */

    public int maxSubArraySumBruteForce(int[] nums){
        // generate all possible subarrays

        // calculate each subarray sum separtely.

        int maxi = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){

                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }

                maxi = Math.max(maxi,sum);
            }
        }

        return maxi;
    }

    /**2. Sol2
     * T.C. O(n^2)
     * S.C. O(1)
     * */

    public int maxSubArraySumSol2(int[] nums){
        // generate all possible subarrays along with the sum

        int maxi = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i = 0; i<n; i++){

            int sum = 0;
            for(int j = i; j<n; j++){

                sum += nums[j];
                maxi = Math.max(maxi,sum);
            }
        }

        return maxi;
    }

    /** 3. Kadane's Algo
     * Memorize the Algo
     * T.C. O(n)
     * S.C. O(1)
     * */
    //prefix sum from a particular i
    public int maxSubArraySumSol3(int[] nums){

        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            maxi = Math.max(maxi,sum);

            if(sum < 0){
                sum = 0;
            }
        }

        return maxi;
    }

    // 4. Extended Version Kadane's Algo returning the maxArray
    public int maxSubArraySumSol4(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currentSum + arr[i] < arr[i]) {
                tempStart = i;
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Print the subarray
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{-5,-4,-3,-2,-1};

        KadanesAlgo obj = new KadanesAlgo();

        System.out.println(obj.maxSubArraySumSol4(nums));
    }
}
