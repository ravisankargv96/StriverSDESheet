
def minSumPath(n, m, matrix):
    # Create a DP table initialized with zeros.
    dp = [[0 for j in range(m)] for i in range(n)]
    
    # Loop through each cell in the matrix.
    for i in range(n):
        for j in range(m):
            if i == 0 and j == 0:
                # Base case: If we are at the top-left corner, set dp[i][j] to the value of that cell.
                dp[i][j] = matrix[i][j]
            else:
                # Calculate the cost of moving up from the cell (i, j).
                up = matrix[i][j]
                if i > 0:
                    up += dp[i-1][j]
                else:
                    # If we are at the top row and can't move up, set 'up' to a large value.
                    up += int(1e9)
                
                # Calculate the cost of moving left from the cell (i, j).
                left = matrix[i][j]
                if j > 0:
                    left += dp[i][j-1]
                else:
                    # If we are at the leftmost column and can't move left, set 'left' to a large value.
                    left += int(1e9)
                
                # Store the minimum cost of reaching the current cell in dp[i][j].
                dp[i][j] = min(up, left)
    
    # The result is stored in the bottom-right corner of the DP table.
    return dp[n-1][m-1]

def main():
    # Example matrix with values representing cell costs.
    matrix = [[5, 9, 6], [11, 5, 2]]
    n = len(matrix)
    m = len(matrix[0])
    
    # Call the minSumPath function and print the result.
    print(minSumPath(n, m, matrix))

if __name__ == "__main__":
    main()

