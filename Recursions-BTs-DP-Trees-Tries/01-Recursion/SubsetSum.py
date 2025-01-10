from typing import List
from visualiser.visualiser import Visualiser as vs

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(ind: int, sum: int):
    
    if ind == len(nums):
        res.append(sum)
        return
    
    # element is picked
    f(ind + 1, sum + nums[ind])
    
    # element is not picked
    f(ind + 1, sum)


if __name__ == "__main__":
    nums = [1, 2, 3]
    res = []
    sum = 0
    
    f(0, sum)
    vs.make_animation(r"img\01-Recursion\subsets_sum.gif", delay = 2)