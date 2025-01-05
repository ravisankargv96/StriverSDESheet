from visualiser.visualiser import Visualiser as vs


# personalized code to run as global variables


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
}

node_properties_kwargs = {
    "shape": styles["shapes"][0],
    "color": styles["colors"][1],
    "style": styles["borders"][0],
    "fillcolor": "#FFEC8B"
}


@vs(ignore_args=None,
    show_return_value= False,
    node_properties_kwargs = node_properties_kwargs)
def subsequence(nums, state, ans):
    if (len(nums) == 0):
        ans.append(state)
        return

    subsequence(nums[1:], state, ans)

    state.append(nums[0])
    subsequence(nums[1:], state, ans)
    state.pop(len(state)-1)


def save():
    file = {
        "dir": r".\Images\test",
        "name": "test_ss20"
    }
    filepath = file["dir"] + "\\" + file["name"]
    vs.make_animation(filepath, delay=1)


def main():
    # Call function
    nums = [1, 2, 3]
    state = []
    ans = []

    print(subsequence(nums, state, ans))


    save()


if __name__ == "__main__":
    main()
