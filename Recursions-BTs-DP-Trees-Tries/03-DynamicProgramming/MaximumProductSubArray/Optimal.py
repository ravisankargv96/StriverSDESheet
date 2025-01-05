


def maxProductSubArray(nums):
    result = nums[0]
    for i in range(len(nums) - 1):
        p = nums[i]
        for j in range(i + 1, len(nums)):
            result = max(result, p)
            p *= nums[j]
        result = max(result, p)  # manages (n-1)th term
    return result

if __name__ == "__main__":
    nums = [1, 2, -3, 0, -4, -5]
    print("The maximum product subarray:", maxProductSubArray(nums))


