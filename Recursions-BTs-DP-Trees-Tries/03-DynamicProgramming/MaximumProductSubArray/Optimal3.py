


def maxProductSubArray(nums):
    prod1 = nums[0]
    prod2 = nums[0]
    result = nums[0]

    for i in range(1, len(nums)):
        temp = max(nums[i], prod1 * nums[i], prod2 * nums[i])
        prod2 = min(nums[i], prod1 * nums[i], prod2 * nums[i])
        prod1 = temp

        result = max(result, prod1)

    return result

if __name__ == "__main__":
    nums = [1, 2, -3, 0, -4, -5]
    print("The maximum product subarray:", maxProductSubArray(nums))


