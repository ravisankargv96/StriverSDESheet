from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def subsetsReps(nums, state, ans):

    ans.append(state.copy())

    for i in range(len(nums)):
        if i != 0 and nums[i] == nums[i - 1]:  # skip the duplicates, except for the first time
            continue

        state.append(nums[i])  # include the element
        subsetsReps(nums[i + 1:], state, ans)  # explore
        state.pop(len(state) - 1)  # remove the element



def main():
    # Call function
    nums = [1,2,2,3]
    state = []
    ans = []
    print(subsetsReps(nums,state,ans))
    # Save recursion tree to a file
    save("subsetsII")


if __name__ == "__main__":
    main()
