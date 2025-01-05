from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

# Above is the boilerplate code to save in image directory

@vs(show_return_value=True,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def Change(num):

    if (num == 0):
        return 0;


    c1 = Change(num//2)
    c2 = Change(num//3)
    c3 = Change(num//4)

    return max(num,c1+c2+c3)




def main():
    # Call function

    Change(12)

    save("indianaChange")


if __name__ == "__main__":
    main()
