from typing import List
from visualiser.visualiser import Visualiser as vs

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(ind, state):
    res.append(state[:])
    for i in range(ind, len(nums)):
        if i != ind and nums[i] == nums[i - 1]:
            continue
        state.append(nums[i])
        f(i + 1, state)
        state.pop()




if __name__ == "__main__":
    nums = [1, 2, 2, 3, 3]
    nums.sort()
    
    res = []
    state = []
    f(0, state)
    vs.make_animation(r"img\01-Recursion\subsetsII.gif", delay = 2)
