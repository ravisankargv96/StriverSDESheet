from visualiser.visualiser import Visualiser as vs


# personalized code to run as global variables

# -------------------------------------------------------------------------------------------------------- #
# node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})

styles = {
    "shapes" : [
        "record",   # square
        "circle"    # circle
    ],
    "colors":[
        "#f57542",  # tomato color
        "#000000",   # black
    ],
    "borders":["filled"],
    "fileName":"test_ss19"
}

shape = styles["shapes"][0]
color = styles["colors"][1]
style = styles["borders"][0]
fillcolor = "#FFEC8B"

# -------------------------------------------------------------------------------------------------------- #

@vs(ignore_args=None,
    show_argument_name = False,
    show_return_value= False,
    node_properties_kwargs={"shape": shape, "color": color, "style": style, "fillcolor": fillcolor})
def subsequence(nums, state, ans):
    if (len(nums) == 0):
        ans.append(state)
        return

    subsequence(nums[1:], state, ans)

    state.append(nums[0])
    subsequence(nums[1:], state, ans)
    state.pop(len(state)-1)


def save(filename):
    dir = r".\Images\test"
    file = dir + "\\" + filename
    vs.make_animation(file, delay=1)

def main():
    # Call function
    nums = [1, 2, 3]
    state = []
    ans = []

    print(subsequence(nums, state, ans))
    # Save recursion tree to a file
    save(styles["fileName"])


if __name__ == "__main__":
    main()
