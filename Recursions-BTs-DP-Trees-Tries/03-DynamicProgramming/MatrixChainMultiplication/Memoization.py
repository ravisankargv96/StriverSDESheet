# Python code to implement the
# matrix chain multiplication using memoization
import sys

# Function to compute minimum multiplication
# recursively
def minMultRec(arr, i, j, memo):

    # If there is only one matrix
    if i + 1 == j:
        return 0

    # Check if the result is already computed
    if memo[i][j] != -1:
        return memo[i][j]

    res = sys.maxsize

    # Place the first bracket at different positions or k
    # and for every placed first bracket, recursively compute
    # minimum cost for remaining brackets (or subproblems)
    for k in range(i + 1, j):
        curr = (minMultRec(arr, i, k, memo) +
                minMultRec(arr, k, j, memo) +
                arr[i] * arr[k] * arr[j])
        res = min(res, curr)

    # Store the result in memo table
    memo[i][j] = res
    return res


def matrixMultiplication(arr):
    n = len(arr)
    memo = [[-1 for _ in range(n)] for _ in range(n)]
    return minMultRec(arr, 0, n - 1, memo)


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 3]
    res = matrixMultiplication(arr)
    print(res)