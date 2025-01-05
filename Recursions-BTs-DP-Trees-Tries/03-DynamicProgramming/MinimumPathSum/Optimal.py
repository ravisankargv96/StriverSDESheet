
def minSumPath(n, m, matrix):
    # Initialize the 'prev' list to keep track of the minimum cost in the previous row.
    prev = [0] * m
    
    # Loop through each row of the matrix.
    for i in range(n):
        # Initialize a temporary list to store the minimum cost for the current row.
        temp = [0] * m
        
        # Loop through each cell in the current row.
        for j in range(m):
            if i == 0 and j == 0:
                # Base case: If we are at the top-left corner, set 'temp[j]' to the value of that cell.
                temp[j] = matrix[i][j]
            else:
                # Calculate the cost of moving up from the cell (i, j).
                up = matrix[i][j]
                if i > 0:
                    up += prev[j]
                else:
                    # If we are at the top row and can't move up, set 'up' to a large value.
                    up = int(1e9)
                
                # Calculate the cost of moving left from the cell (i, j).
                left = matrix[i][j]
                if j > 0:
                    left += temp[j-1]
                else:
                    # If we are at the leftmost column and can't move left, set 'left' to a large value.
                    left = int(1e9)
                
                # Store the minimum cost of reaching the current cell in 'temp[j]'.
                temp[j] = min(up, left)
        
        # Update 'prev' with the 'temp' list for the next iteration.
        prev = temp
    
    # The result is stored in the last element of the 'prev' list (bottom-right corner).
    return prev[m - 1]

def main():
    # Example matrix with values representing cell costs.
    matrix = [[5, 9, 6], [11, 5, 2]]
    n = len(matrix)
    m = len(matrix[0])
    
    # Call the minSumPath function and print the result.
    print(minSumPath(n, m, matrix))

if __name__ == '__main__':
    main()

