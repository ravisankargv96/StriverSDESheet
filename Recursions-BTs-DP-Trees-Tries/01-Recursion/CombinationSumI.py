from typing import List
from visualiser.visualiser import Visualiser as vs


@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(ind, state, target):

    if ind == len(nums):
        if target == 0:
            res.append(state[:])
        return

    # Consider Case: Pruning other branches i.e. nums[ind] > target
    if nums[ind] <= target:
        state.append(nums[ind])
        f(ind, state, target - nums[ind])
        state.pop()

    # Non Consider Case:
    f(ind + 1, state, target)




if __name__ == "__main__":
    nums = [2, 3, 6, 7]
    target = 7
    res = []
    state = []

    f(0, state, target)
    vs.make_animation(r"img\01-Recursion\combinationSumI.gif", delay = 2)

    