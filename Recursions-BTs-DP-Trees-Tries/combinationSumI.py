from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

# Above is the boilerplate code to save in image directory

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def Comb(arr, target, state, ans):

    if (target == 0):
        ans.append(state.copy())
        return;


    for i in range(len(arr)):
        if(target - arr[i] >= 0):
            state.append(arr[i])
            Comb(arr[i:], target - arr[i], state, ans)
            state.pop(len(state)-1)



def main():
    # Call function
    candidates = [2,3,6,7]
    target = 7
    state = []
    ans = []

    Comb(candidates, target, state, ans);

    save("combinationSumI")


if __name__ == "__main__":
    main()
