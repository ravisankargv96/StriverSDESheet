from typing import List

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        s = ""
        res = []
        # create string
        for i in range(1, n + 1):
            s += str(i)
        self.permutationHelper(s, 0, res)
        # sort the generated permutations
        res.sort()
        # make k 0-based indexed to point to kth sequence
        return res[k - 1]


    def permutationHelper(self, s: str, index: int, res: List[str]) -> None:
        if index == len(s):
            res.append(s)
            return
        for i in range(index, len(s)):
            s = self.swap(s, i, index)
            self.permutationHelper(s, index + 1, res)
            s = self.swap(s, i, index)


    def swap(self, s: str, i: int, j: int) -> str:
        s = list(s)
        s[i], s[j] = s[j], s[i]
        return "".join(s)




if __name__ == "__main__":
    n = 3
    k = 3
    obj = Solution()
    ans = obj.getPermutation(n, k)
    print("The Kth permutation sequence is", ans)