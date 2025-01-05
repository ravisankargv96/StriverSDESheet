from typing import List




class Solution:


    ans = []


    def recurPermute(self, index: int, nums: List[int], ans: List[List[int]]):
        if index == len(nums):
            ans.append(nums[:])
            return
        for i in range(index, len(nums)):
            nums[index], nums[i] = nums[i], nums[index]
            self.recurPermute(index + 1, nums, ans)
            nums[index], nums[i] = nums[i], nums[index]


    def permute(self, nums: List[int]) -> List[List[int]]:
        self.ans = []
        self.recurPermute(0, nums, self.ans)
        return self.ans




if __name__ == "__main__":
    obj = Solution()
    v = [1, 2, 3]
    sum = obj.permute(v)
    print("All Permutations are ")
    for i in range(len(sum)):
        for j in range(len(sum[i])):
            print(sum[i][j], end=" ")
        print()