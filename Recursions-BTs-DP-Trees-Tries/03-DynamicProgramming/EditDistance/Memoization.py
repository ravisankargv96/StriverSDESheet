
def editDistanceUtil(S1, S2, i, j, dp):
    # Base cases
    if i < 0:
        return j + 1
    if j < 0:
        return i + 1

    # If the result for this subproblem is already computed, return it
    if dp[i][j] != -1:
        return dp[i][j]

    # If the characters at the current positions match, no operation is needed
    if S1[i] == S2[j]:
        dp[i][j] = editDistanceUtil(S1, S2, i - 1, j - 1, dp)
    else:
        # Calculate the minimum of three choices:
        # 1. Replace the current character (diagonal move)
        # 2. Insert a character into S1 (move up)
        # 3. Delete a character from S1 (move left)
        dp[i][j] = 1 + min(
            editDistanceUtil(S1, S2, i - 1, j - 1, dp),
            min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp))
        )

    return dp[i][j]

def editDistance(S1, S2):
    n = len(S1)
    m = len(S2)

    # Initialize a 2D DP array with -1 values
    dp = [[-1 for _ in range(m)] for _ in range(n)]

    # Calculate and return the edit distance
    return editDistanceUtil(S1, S2, n - 1, m - 1, dp)

def main():
    s1 = "horse"
    s2 = "ros"

    # Calculate and print the minimum number of operations required
    print("The minimum number of operations required is:", editDistance(s1, s2))

if __name__ == "__main__":
    main()

