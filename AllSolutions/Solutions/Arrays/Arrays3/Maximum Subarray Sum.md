Give an array **arr[]**, the task is to find the subarray that has the maximum sum & return its sum.

### Examples:
```
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2

Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
```

### BruteForce Approach:
1. Generate all the subarrays.
2. Calculate the sum foreach Iteration
3. Return the maximum calculated sum.

```
static int maxSubarraySum(int[] arr) {
        int res = arr[0];
```
Generating all the possible subarrays
```  
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
```
**Foreach Subarray:** Calculate **sum[i:j]**
```
                currSum = currSum + arr[j];              
```
Update **res** with maximum value Foreach subarray
```
				res = Math.max(res, currSum);
            }
        }
```
After iterating through all the subArrays, return **res**.
```
        return res;
	}
```
### Kadane's Algorithm:

We know
$subArray[i:j-1] + subArray[j] => subArray[i:j]$ 

At everystep we have 2 choices:
- **Choice 1:**  if $subArray[i:j-1]$ is `+ve` extend the previous sum i.e $subArray[i:j-1] + subArray[j]$ 
- **Choice 2:** if $subArray[i:j-1]$ is `-ve` ignore the previous sum i.e. $subArray[j:j]$ 