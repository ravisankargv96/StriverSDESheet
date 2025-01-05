
import sys

# Function to solve the 0/1 knapsack problem using dynamic programming.
def knapsack(wt, val, n, W):
    # Initialize a list 'prev' to store the maximum value for different capacities.
    prev = [0] * (W + 1)
    
    # Base condition: Fill in the first row of 'prev' based on the capacity 'W'.
    for i in range(wt[0], W + 1):
        prev[i] = val[0]
    
    # Iterate through the items and capacities in reverse order.
    for ind in range(1, n):
        for cap in range(W, -1, -1):
            # Calculate the maximum value when the current item is not taken.
            notTaken = 0 + prev[cap]
            
            # Calculate the maximum value when the current item is taken (if its weight allows).
            taken = -sys.maxsize
            if wt[ind] <= cap:
                taken = val[ind] + prev[cap - wt[ind]]
                
            # Update the 'prev' list with the maximum of notTaken and taken values.
            prev[cap] = max(notTaken, taken)
    
    # The result is stored in 'prev[W]', representing the maximum value of items the thief can steal.
    return prev[W]

def main():
    wt = [1, 2, 4, 5]
    val = [5, 4, 8, 6]
    W = 5
    n = len(wt)

    # Find and print the maximum value of items the thief can steal.
    print("The Maximum value of items the thief can steal is", knapsack(wt, val, n, W))

if __name__ == '__main__':
    main()

