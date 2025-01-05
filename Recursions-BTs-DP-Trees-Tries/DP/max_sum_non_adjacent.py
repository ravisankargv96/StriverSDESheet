import math

#pre_requisite

def subsequence(nums, ind, state, ans):
    if (ind == len(nums)):
        print(state)
        ans.append(state)
        return

    subsequence(nums, ind + 1, state, ans) # not_pick

    state.append(nums[ind])
    subsequence(nums, ind+1, state, ans) # picking
    state.pop(len(state)-1)


def max_sum_subsequence(nums, ind):

    if(ind == len(nums)):
        return 0

    left = max_sum_subsequence(nums, ind+1)
    right = nums[ind] +  max_sum_subsequence(nums, ind+1)

    return max(left, right)


#Actual solution:

#recursive -> bottom up
def maxsum_nonadj_elems(nums, ind):

    if(ind >= len(nums)):
        return 0

    left = maxsum_nonadj_elems(nums, ind + 1)
    right = nums[ind] + maxsum_nonadj_elems(nums, ind + 2)

    return max(left, right)


#memoization
def maxsum_nonadj_elems_memo(nums, ind):

    if ind in memo:
        return memo[ind]

    if(ind >= len(nums)):
        return 0

    left = maxsum_nonadj_elems_memo(nums, ind + 1)
    right = nums[ind] + maxsum_nonadj_elems_memo(nums, ind + 2)

    memo[ind] = max(left, right)
    return memo[ind]


#recursive_V2 -> Top Down
def maxsum_nonadj_elems_v2(nums, ind):

    if(ind == 0):
        return nums[ind]

    if(ind < 0):
        return 0

    left = maxsum_nonadj_elems_v2(nums, ind - 1)
    right = nums[ind] + maxsum_nonadj_elems_v2(nums, ind - 2)

    return max(left, right)


#recursive_memo
def maxsum_nonadj_elems_v2_memo(nums, ind):

    if ind in memo:
        return memo[ind]

    if (ind == 0):
        return nums[ind]

    if (ind < 0):
        return 0

    left = maxsum_nonadj_elems_v2_memo(nums, ind - 1)
    right = nums[ind] + maxsum_nonadj_elems_v2_memo(nums, ind - 2)

    memo[ind] = max(left, right)
    return memo[ind]


def tabulation():

    dp = [nums[0], max(nums[1],nums[0]) ]

    for i in range(2, len(nums)):
        value = max(dp[i-1], nums[i] + dp[i-2])
        dp.append(value)

    return dp[-1]



def tabulation_space_optimization():

    first, second = nums[0], max(nums[1],nums[0])

    for i in range(2, len(nums)):
        value = max(second, nums[i] + first)

        first, second = second, value


    return value



if __name__ == "__main__":
    nums1 = [1,2,3,4]
    nums = [2, 1, 4, 9]
    nums3 = [1, 2, 4]

    state = []
    ans = []

    print("subsequences")
    subsequence(nums,0,state,ans)

    print("maxsum_subsequence", max_sum_subsequence(nums,0))

    print("maxsum_non_adj : ", maxsum_nonadj_elems(nums, 0))

    memo = {}

    print("maxsum_non_adj_memo : ", maxsum_nonadj_elems_memo(nums, 0))


    #recursive :-> top -> down
    print("tabulation : ",tabulation())
    print("tabulation_space_optimization : ", tabulation_space_optimization())