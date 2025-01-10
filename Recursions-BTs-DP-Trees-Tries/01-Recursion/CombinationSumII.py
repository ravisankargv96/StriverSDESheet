from typing import List
from visualiser.visualiser import Visualiser as vs


@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(ind: int, state: List, target: int):
    if target == 0:
        res.append(state[:])
        return
    for i in range(ind, len(nums)):
        if i > ind and nums[i] == nums[i - 1]:
            continue
        if nums[i] > target:
            break
        state.append(nums[i])
        f(i + 1, state, target - nums[i])
        state.pop()


if __name__ == "__main__":
    nums = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    
    res = []
    state = []
    nums.sort()
    
    f(0, state, target)
    vs.make_animation(r"img\01-Recursion\combinationSumII.gif", delay = 2)

