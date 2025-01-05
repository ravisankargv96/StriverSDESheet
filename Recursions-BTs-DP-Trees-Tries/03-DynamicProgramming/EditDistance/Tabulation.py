
def editDistance(S1, S2):
    n = len(S1)
    m = len(S2)

    # Initialize a 2D DP array of size (n+1) x (m+1) with all elements set to 0
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

    # Initialize the first row and first column of the DP array
    for i in range(n + 1):
        dp[i][0] = i
    for j in range(m + 1):
        dp[0][j] = j

    # Fill in the DP array using dynamic programming
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            # If the characters at the current positions match, no operation is needed
            if S1[i - 1] == S2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            else:
                # Calculate the minimum of three choices:
                # 1. Replace the current character (diagonal move)
                # 2. Insert a character into S1 (move up)
                # 3. Delete a character from S1 (move left)
                dp[i][j] = 1 + min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1]))

    # The final value in dp[n][m] is the minimum number of operations required
    return dp[n][m]

def main():
    s1 = "horse"
    s2 = "ros"

    # Calculate and print the minimum number of operations required
    print("The minimum number of operations required is:", editDistance(s1, s2))

if __name__ == "__main__":
    main()

