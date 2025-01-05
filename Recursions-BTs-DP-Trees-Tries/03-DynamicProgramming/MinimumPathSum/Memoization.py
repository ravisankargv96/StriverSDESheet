
def minSumPathUtil(i, j, matrix, dp):
    # Base case: If we are at the top-left corner, return the value of that cell.
    if i == 0 and j == 0:
        return matrix[0][0]
    
    # Base case: If we are out of bounds (negative indices), return a very large value.
    if i < 0 or j < 0:
        return int(1e9)
    
    # If we have already calculated the minimum sum for this cell, return it.
    if dp[i][j] != -1:
        return dp[i][j]

    # Calculate the minimum sum path recursively by considering both up and left moves.
    up = matrix[i][j] + minSumPathUtil(i-1, j, matrix, dp)
    left = matrix[i][j] + minSumPathUtil(i, j-1, matrix, dp)

    # Store the minimum of the two possible paths in the DP table.
    dp[i][j] = min(up, left)
    return dp[i][j]


def minSumPath(n, m, matrix):
    # Create a DP table initialized with -1 values.
    dp = [[-1 for j in range(m)] for i in range(n)]
    
    # Call the utility function to find the minimum sum path.
    return minSumPathUtil(n-1, m-1, matrix, dp)


def main():
    # Example matrix with values representing cell costs.
    matrix = [[5, 9, 6],
              [11, 5, 2]]

    n = len(matrix)
    m = len(matrix[0])

    # Call the minSumPath function and print the result.
    print(minSumPath(n, m, matrix))


if __name__ == '__main__':
    main()

