from visualiser.visualiser import Visualiser as vs
import os

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

def save():
    name = input("Enter the file name for saving : ")
    file = {
        "dir": os.getcwd(),
        "name": name
    }
    filepath = file["dir"] + "\\" + file["name"] + ".gif"
    vs.make_animation(filepath, delay=1)


@vs(ignore_args=None,
    show_return_value= False,
    node_properties_kwargs = node_properties_kwargs)
def f(n):
    if n <= 1:
        return 1

    left = f(n - 1)
    right = f(n - 2)

    return  left + right

if __name__ == "__main__":

    print(f(5))

    save()
