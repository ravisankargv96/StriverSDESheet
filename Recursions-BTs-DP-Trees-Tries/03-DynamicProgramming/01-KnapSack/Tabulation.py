
import sys

# Function to solve the 0/1 knapsack problem using dynamic programming.
def knapsack(wt, val, n, W):
    # Initialize a 2D DP array to store the maximum value for different capacities and items.
    dp = [[0 for i in range(W + 1)] for j in range(n)]
    
    # Base condition: Fill in the first row based on the capacity 'W'.
    for i in range(wt[0], W + 1):
        dp[0][i] = val[0]
        
    # Iterate through the items and capacities.
    for ind in range(1, n):
        for cap in range(W + 1):
            # Calculate the maximum value when the current item is not taken.
            not_taken = 0 + dp[ind - 1][cap]
            
            # Calculate the maximum value when the current item is taken (if its weight allows).
            taken = -sys.maxsize
            if wt[ind] <= cap:
                taken = val[ind] + dp[ind - 1][cap - wt[ind]]
                
            # Update the DP table with the maximum of not_taken and taken values.
            dp[ind][cap] = max(not_taken, taken)
    
    # The result is stored in the bottom-right cell of the DP array.
    return dp[n - 1][W]

def main():
    wt = [1, 2, 4, 5]
    val = [5, 4, 8, 6]
    W = 5
    n = len(wt)
                                 
    # Find and print the maximum value of items the thief can steal.
    print("The Maximum value of items the thief can steal is", knapsack(wt, val, n, W))

if __name__ == "__main__":
    main()

