
import sys

# Recursive function to solve the unbounded knapsack problem
def knapsackUtil(wt, val, ind, W, dp):
    # Base case: If there are no more items to consider (index is 0)
    if ind == 0:
        return (W // wt[0]) * val[0]

    # If the result for this state is already calculated, return it
    if dp[ind][W] != -1:
        return dp[ind][W]

    # Calculate the maximum value when the current item is not taken
    notTaken = knapsackUtil(wt, val, ind - 1, W, dp)

    # Initialize a variable to store the maximum value when the current item is taken
    taken = -sys.maxsize
    if wt[ind] <= W:
        taken = val[ind] + knapsackUtil(wt, val, ind, W - wt[ind], dp)

    # Store the maximum of "notTaken" and "taken" in the DP table
    dp[ind][W] = max(notTaken, taken)
    return dp[ind][W]

# Function to find the maximum value that can be obtained in unbounded knapsack
def unboundedKnapsack(n, W, val, wt):
    # Create a DP table initialized with -1
    dp = [[-1 for _ in range(W + 1)] for _ in range(n)]
    return knapsackUtil(wt, val, n - 1, W, dp)

def main():
    wt = [2, 4, 6]
    val = [5, 11, 13]
    W = 10
    n = len(wt)

    print("The Maximum value of items the thief can steal is", unboundedKnapsack(n, W, val, wt))

if __name__ == "__main__":
    main()


