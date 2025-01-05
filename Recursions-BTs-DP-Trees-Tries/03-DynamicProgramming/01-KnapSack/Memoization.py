
import sys

# Recursive function to find the maximum value of items the thief can steal
# using the 0/1 knapsack problem approach.
def knapsackUtil(wt, val, ind, W, dp):
    # Base case: If we are at the first item (index 0), check if it can be included in the knapsack.
    if ind == 0:
        if wt[0] <= W:
            return val[0]
        else:
            return 0
    
    # If the result for this combination of 'ind' and 'W' has already been computed, return it.
    if dp[ind][W] != -1:
        return dp[ind][W]
    
    # Calculate the value when the current item is not taken.
    notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp)
    
    # Calculate the value when the current item is taken (if its weight allows).
    taken = -sys.maxsize
    if wt[ind] <= W:
        taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp)
    
    # Update the DP table with the maximum of the two possibilities.
    dp[ind][W] = max(notTaken, taken)
    return dp[ind][W]

# Wrapper function for the knapsack problem.
def knapsack(wt, val, n, W):
    # Initialize a DP table to store the results of subproblems.
    dp = [[-1 for j in range(W + 1)] for i in range(n)]
    # Call the utility function to find the maximum value the thief can steal.
    return knapsackUtil(wt, val, n - 1, W, dp)

def main():
    wt = [1, 2, 4, 5]
    val = [5, 4, 8, 6]
    W = 5
    n = len(wt)
    
    # Find and print the maximum value of items the thief can steal.
    print("The Maximum value of items the thief can steal is", knapsack(wt, val, n, W))

if __name__ == "__main__":
    main()

