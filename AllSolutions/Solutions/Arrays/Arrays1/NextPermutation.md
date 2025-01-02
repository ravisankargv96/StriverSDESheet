## Problem Statement:
Give an array of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e. sorted in ascending order).

### Example 1:
```
Input format:
[1, 3, 2]
Output format:
[2, 1, 3]
Explanation:
All permutations of [1, 2, 3] are 
[
[1, 2, 3],
[1, 3, 2],
[2, 1, 3],
[2, 3, 1],
[3, 1, 2],
[3, 2, 1]
]
So the next permuation just after [1, 3, 2] is [2, 1, 3]
```

### Example 2:
```
Input format:
[3, 2, 1]
Output format:
[1, 2, 3]
Explanation:
As we see all permutations of [1, 2, 3] we find [3, 2, 1] at the last position. So, we have to return the topmost permutation.
```

## Solution:
### BruteForce:
1. Find all possible permutations of elements present and store them.

### Find all possible permutations
```
                        f([**1**, 2, 3])
                           /|\
f([1, **2**, 3])          f([2, **1**, 3])               f([3, **2**, 1])
    /\                        /\                          /\
f([1, 2, **3**]) f([1, 3, **2**])   f([2, 1, **3**]) f([2, 3, **1**])   f([3, 2, **1**]) f([3, 1, **2**])
```

Generate permutations: f([[]],[**1**, 2, 3])
```
static void permutations(List<int[]> res, int[] arr, int idx) {
      
```
Base case: if idx reaches EOArray
```
		if (idx == arr.length - 1) {
            res.add(arr.clone());
            return;
        }
```

Swap idx with i to get permuted version:
```
        for (int i = idx; i < arr.length; i++) {
          
            swap(arr, idx, i);
```

Focus on subproblem:
```  
            permutations(res, arr, idx + 1);
```
Making original for next iteration:
```
            // Backtracking
            swap(arr, idx, i);  
        }
    }
```

2. Search input from all possible permutations
3. Print the next permutation present in a cyclic order.

### T.C. `O(n!*n*log(n!))` S.C. `O(n!)`

### Optimal Approach

Let's try some examples
```
[1, 2, 3, 4, 5]: next is
[1, 2, 3, 5, 4]
Observation: 4 moves & 5 comes in place of it.

[1, 2, 3, 5, 4]: next is
[1, 2, 4, 3, 5]
Observation: 4 replaces by 3. Then 3 comes before 5
(mainly 3 & 5 are in sorted order)

[1, 2, 3, 6, 5, 4]: next is
[1, 2, 4, 3, 5, 6]
Observation: 4 replaces 3. Then right side to 4 numbers are sorted.

[3, 2, 1]: next is 
[1, 2, 3]
Observation: All elements are reverse sorted. Result is whole array sorted.
```

Algo:
1. From right ignore the descending sequence. `(n-1 >= seq >= 0)`
2. Find the pivot element `i.e. i = seq - 1`  & `arr[i] < arr[seq]`
	1. Note: If you don't find pivot element entire seq is descending order, Make it to ascending order
3. Replace the ith element with slightly higher element in the sequence. `since arr[i] < arr[seq], seq range always contains slightly higher element`
4. Swap the element with slight highest element, Sort the elements in `seq` range.

### Code:

```
class Solution {
    public void nextPermutation(int[] nums) {
```
Init: len, seq, j & pivot
```
        int n = nums.length;
        int seq, j;
        int pivot = -1;
```

Ignoring descending sequence & finding pivot
```  
        //Find pivot
        for (seq = n - 1; seq >= 1; seq--){
            if(nums[seq - 1] < nums[seq]){
                pivot = seq - 1;
                break;
            }
        }

```

Entire sequence can be desc or Only some portion can be descending one.
```  

        if(pivot == -1){
```
**Entire seq is descending:**
```
            asc(nums, pivot + 1);
```
**Some portion is descending**, find the jth element (slight highest of `nums[pivot]`).
```
        } else{

            for(j = n-1; j >= seq; j--){
                if(nums[j] > nums[pivot]){
                    break;
                }
            }
```
Replace `nums[pivot] with nums[j]` & **make nums[pivot:] in ascending order**
```
            swap(nums, pivot, j);

            asc(nums, pivot+1);

        } 
    }

  
```
**Helper method:** Swap(nums, i, j)
```
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

```
**Helper method:** asc(nums, i+1) 
```  
    public void asc(int[] nums, int low){
        int high = nums.length - 1;
        while(low < high){
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
```