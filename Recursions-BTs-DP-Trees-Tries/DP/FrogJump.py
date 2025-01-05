import math
from math import inf


def frog_jump(ind):

    if ind == 0:
        return 0

    if ind == 1:
        return abs(height[1] - height[0])


    left = abs(height[ind] - height[ind - 1]) + frog_jump(ind - 1)

    right = abs(height[ind] - height[ind - 2]) + frog_jump(ind - 2)

    return min(left, right)


def frog_jump_memo(ind):

    if ind in memo:
        return memo[ind]

    if ind == 0:
        return 0

    if ind == 1:
        return abs(height[1] - height[0])


    left = abs(height[ind] - height[ind - 1]) + frog_jump(ind - 1)

    right = abs(height[ind] - height[ind - 2]) + frog_jump(ind - 2)

    memo[ind] = min(left, right)
    return memo[ind]


def tabulation():

    dp = [0, abs(height[1] - height[0])]

    for i in range(2, len(height)):
        value = min(abs(height[i] - height[i-1]) + dp[i-1], abs(height[i] - height[i-2]) + dp[i-2])
        dp.append(value)

    return dp[-1]


def tabulation_space_opt():

    first, second = 0, abs(height[1] - height[0])

    for i in range(2, len(height)):
        value = min(abs(height[i] - height[i-1]) + second, abs(height[i] - height[i-2]) + first)
        first, second = second, value

    return value



def frog_jump_ksteps(ind):

    if ind == 0:
        return 0

    if ind == 1:
        return abs(height[1] - height[0])

    mini = inf
    for k in range(1,steps + 1):

        if(ind - k >= 0):
            value = abs(height[ind] - height[ind - k]) + frog_jump_ksteps(ind - k)

            mini = min(mini, value)


    return mini


def frog_jump_ksteps_memo(ind):

    if ind in memo:
        return memo[ind]

    if ind == 0:
        return 0

    if ind == 1:
        return abs(height[1] - height[0])

    mini = inf
    for k in range(1,steps + 1):

        if(ind - k >= 0):
            value = abs(height[ind] - height[ind - k]) + frog_jump_ksteps(ind - k)

            mini = min(mini, value)

    memo[ind] = mini
    return memo[ind]


def tabulation_ksteps():
    dp = [0, abs(height[1] - height[0])]

    for i in range(2, len(height)):

        value = math.inf
        for k in range(1, i+1):
            value = min(value, abs(height[i] - height[i - k]) + dp[i - k])

        dp.append(value)

    return dp[-1]


#write this code later
def tabulation_ksteps_space_optimization(steps):
    dp = [-1 for i in range(steps)]

    dp[0], dp[1] = 0, abs(height[1] - height[0])

    for i in range(2, len(height)):

        value = math.inf
        for k in range(1, i+1):
            value = min(value, abs(height[i] - height[i - k]) + dp[i - k])

        dp[i] = value

    return dp[-1]


if __name__ == "__main__":
    height = [10, 20, 30, 10]
    height2 = [10, 50, 10]

    memo = {}


    steps = 2

    print(frog_jump(len(height) - 1))
    print(frog_jump_memo(len(height) - 1))
    print("tabulation : ",tabulation())
    print("tabulation_space_opt : ", tabulation_space_opt())

    memo.clear()
    print(frog_jump_ksteps(len(height) - 1))
    print(frog_jump_ksteps_memo(len(height) - 1))
    print(tabulation_ksteps())
