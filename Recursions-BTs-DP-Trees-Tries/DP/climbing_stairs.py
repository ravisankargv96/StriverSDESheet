# Recursive approach
def climbing_stairs(n):
    if n <= 1:
        return 1

    left = climbing_stairs(n - 1)
    right = climbing_stairs(n - 2)

    return  left + right

# Memoization approach
def climbing_stairs_memo(n, memo={}):

    if n in memo:
        return memo[n]

    if n <= 1:
        return 1

    left = climbing_stairs_memo(n - 1, memo)
    right = climbing_stairs_memo(n - 2, memo)

    memo[n] = left + right
    return memo[n]


# Tabulation approach
def count_ways_tabulation(n):
    if n <= 1:
        return 1

    ways = [0] * (n + 1)
    ways[0], ways[1] = 1, 1

    for i in range(2, n + 1):
        ways[i] = ways[i - 1] + ways[i - 2]

    return ways[n]

# Space-optimized Tabulation approach
def count_ways_space_optimized_tabulation(n):
    if n <= 1:
        return 1

    a, b = 1, 1

    for _ in range(2, n + 1):
        a, b = b, a + b

    return b

if __name__ == "__main__":
    print(climbing_stairs(3))
    print(climbing_stairs_memo(3,{}))