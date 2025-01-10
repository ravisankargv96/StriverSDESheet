from typing import List
from visualiser.visualiser import Visualiser as vs


@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#000000", "style": "filled", "fillcolor": "grey"})
def f(idx: int, state: List[int]):
    if idx == len(state):
        ans.append(state[:])
        return
    for i in range(idx, len(state)):
        state[idx], state[i] = state[i], state[idx]
        f(idx + 1, state)
        state[idx], state[i] = state[i], state[idx]


if __name__ == "__main__":
    nums = [1, 2, 3]
    ans = []
    state = nums
    f(0, state)
    vs.make_animation(r"img\01-Recursion\PermutationI.gif", delay = 2)

    