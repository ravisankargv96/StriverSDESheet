
def countWaysToMakeChangeUtil(arr, ind, T, dp):
    # Base case: If we have reached the first element in the array.
    if ind == 0:
        return 1 if T % arr[0] == 0 else 0

    # If the result for this state is already calculated, return it.
    if dp[ind][T] != -1:
        return dp[ind][T]

    # Calculate the number of ways when the current element is not taken.
    not_taken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp)

    # Initialize a variable for the number of ways when the current element is taken.
    taken = 0
    if arr[ind] <= T:
        taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp)

    # Store the total number of ways in the DP table.
    dp[ind][T] = not_taken + taken
    return dp[ind][T]

# Function to count the number of ways to make change for a given target amount
def countWaysToMakeChange(arr, n, T):
    # Create a DP table with initial values as -1.
    dp = [[-1 for i in range(T + 1)] for j in range(n)]
    return countWaysToMakeChangeUtil(arr, n - 1, T, dp)

def main():
    arr = [1, 2, 3]
    target = 4
    n = len(arr)
    print("The total number of ways is", countWaysToMakeChange(arr, n, target))

if __name__ == "__main__":
    main()


