
import sys

# Function to solve the unbounded knapsack problem using dynamic programming
def unboundedKnapsack(n, W, val, wt):
    # Create a DP table to store the maximum value for different capacities
    dp = [[0 for j in range(W + 1)] for i in range(n)]

    # Initialize the base condition for the first item
    for i in range(wt[0], W + 1, wt[0]):
        dp[0][i] = ((i // wt[0]) * val[0])

    # Fill in the DP table for the remaining items and capacities
    for ind in range(1, n):
        for cap in range(W + 1):
            # Calculate the maximum value when the current item is not taken
            notTaken = 0 + dp[ind - 1][cap]

            # Initialize a variable to store the maximum value when the current item is taken
            taken = -sys.maxsize
            if wt[ind] <= cap:
                taken = val[ind] + dp[ind][cap - wt[ind]]

            # Store the maximum of "notTaken" and "taken" in the DP table
            dp[ind][cap] = max(notTaken, taken)

    # The maximum value for the entire knapsack is at dp[n-1][W]
    return dp[n - 1][W]

def main():
    wt = [2, 4, 6]
    val = [5, 11, 13]
    W = 10
    n = len(wt)

    print("The Maximum value of items the thief can steal is", unboundedKnapsack(n, W, val, wt))

if __name__ == "__main__":
    main()


