
def maxProductSubArray(nums):
    result = float('-inf')
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            prod = 1
            for k in range(i, j + 1):
                prod *= nums[k]
            result = max(result, prod)
    return result

if __name__ == "__main__":
    nums = [1, 2, -3, 0, -4, -5]
    print("The maximum product subarray:", maxProductSubArray(nums))


