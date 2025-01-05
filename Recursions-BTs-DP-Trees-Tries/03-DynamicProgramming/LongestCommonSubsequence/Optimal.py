
def lcs(s1, s2):
    n = len(s1)
    m = len(s2)

    # Initialize two arrays, 'prev' and 'cur', to store the DP values
    prev = [0] * (m + 1)
    cur = [0] * (m + 1)

    # Loop through the characters of both strings to compute LCS
    for ind1 in range(1, n + 1):
        for ind2 in range(1, m + 1):
            if s1[ind1 - 1] == s2[ind2 - 1]:
                # If the characters match, increment LCS length by 1
                cur[ind2] = 1 + prev[ind2 - 1]
            else:
                # If the characters do not match, take the maximum of LCS
                # by excluding one character from s1 or s2
                cur[ind2] = max(prev[ind2], cur[ind2 - 1])
        
        # Update 'prev' to be the same as 'cur' for the next iteration
        prev = cur[:]

    # The value in 'prev[m]' represents the length of the Longest Common Subsequence
    return prev[m]

def main():
    s1 = "acd"
    s2 = "ced"

    print("The Length of Longest Common Subsequence is", lcs(s1, s2))

if __name__ == '__main__':
    main()

