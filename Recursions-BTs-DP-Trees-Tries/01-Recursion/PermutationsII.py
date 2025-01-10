from typing import List
from visualiser.visualiser import Visualiser as vs


@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(idx, state):
    if idx == n:
        res.append(state[:])
        return
    for j in range(n):
        if visited[j]: 
            continue
        
        if j > 0 and nums[j] == nums[j-1] and not visited[j-1]:
            continue
        state.append(nums[j])
        visited[j] = True
        
        f(idx+1, state)
        
        state.pop()
        visited[j] = False

        
if __name__ == "__main__":
    nums = [1, 2, 2, 3]
    res = []
    n = len(nums)
    visited = [False] * n 
    state = []
    
    nums.sort()
    f(0, state)
    vs.make_animation(r"img\01-Recursion\PermutationII.gif", delay = 2)

