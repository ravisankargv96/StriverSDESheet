from typing import List
from visualiser.visualiser import Visualiser as vs

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(idx, state):
    if idx == len(nums):
        res.append(state[:])
        return
    
    state.append(nums[idx])
    f(idx+1, state)

    state.pop()
    f(idx+1, state)

    
if __name__ == "__main__":
    nums = [1,2,3]
    res = []
    state = []
    
    f(0, state)
    vs.make_animation(r"img\01-Recursion\subsets.gif", delay = 2)
