### subsets
1. Solved using binary conditions
2. Solved using n-ary conditions
	
Eg: CoinChange problem.
	
DP:
1. Min cost in climbing stairs.
    ## Approach
    f(i, cost) = cost[i] + min(f(i-1, cost), f(i-2, cost))
    # Base case
    i == 0 or i == 1 return cost[i]

    url: https://www.geeksforgeeks.org/minimum-cost-to-reach-the-top-of-the-floor-by-climbing-stairs/#using-recursion-o2n-time-and-on-space


2. Coin change - Min coins to make sum
    ## Approach
    global = coins
    f(i,sum) = min(1 + f(i, sum - coins[i]), f(i+1, sum)) // increasing order
    f(n, sum) = min(1 + f(n, sum - coins[n]), f(n - 1, sum)) // decreasing order n - i ; i = 0 
    # Base case
    if sum == 0: return 0;
    if sum < 0 or i == len(coins): return +inf;

    url: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/#using-recursion-onsum-time-and-osum-space


3. max sum for non-adjacent elements
    ## Approach
    pick & non pick case 
    f(i) = max(nums[i] + f(i + 2), f(i+1)) // increasing  i
    f(n) = max(nums[n-1] + f(n - 2), f(n - 1)) // decreasing  n - i; i = 0

    # Base case
    f(0) = 0
    f(1) = arr[0]

    url: https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent-set-2/


4. House robber 2

    url: https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/

5. Rod cutting, max no. of segments x, y, z
    ## Top Down approach
    f(n) = 1 + max(f(n - x), f(n - y), f(n - z))
    ## Base case 
    f(-ve) = -1 (-inf is also best option)
    f(0) = 0

    url: https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/

6. Count dearrangements (None of the elements are in same position)
    ## Top Down approach
    f(n) = (n - 1)*( f(n-1) + f(n-2) ) 

    url: https://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-element-appears-in-its-original-position/

7. Painting fence algorithm
    ## Top Down approach
    f(n) = f(n-1) * (k-1) +  f(n-2) * (k-1)

    url: https://www.geeksforgeeks.org/painting-fence-algorithm/

2D DP Series:
1. 0/1 Knapsack
    ## More like subsets
    f(n,W) = (wt[n-1] > W) ? f(n-1, W) : max( val[n-1] + f(n-1, W-wt[n-1]), f(n-1, W) )
    # Base Conditions
    f(0,W) = 0
    f(n,0) = 0

## Striver SDE Sheet DP.
1. Max Product Subarray
    ## Approach
    Feels like a normal array like problem.
    
2. Longest Increasing Subsequence
3. Longest Common Subsequence 
4. 0/1 Knapsack
5. Edit Distance
6. Maximum sum increasing subsequence 
7. Matrix chain multiplication

8. Minimum sum path in the matrix
9. Coin change 
10. Subset Sum 
11. Rod Cutting 
12. Egg Dropping 
13. Word Break 
14. Palindrome Partioning (MCM Variation)
15. Maximum profit in Job scheduling
