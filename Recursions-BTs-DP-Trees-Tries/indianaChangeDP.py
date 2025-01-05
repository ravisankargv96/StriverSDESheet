from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

# Above is the boilerplate code to save in image directory

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def Change(num):

    if(dp[num] != -1):
        return dp[num]

    if (num == 0):
        return 0;


    c1 = Change(num//2)
    c2 = Change(num//3)
    c3 = Change(num//4)

    dp[num] = max(num,c1+c2+c3)
    return dp[num]




def main():
    # Call function


    Change(num)

    save("indianaChangeDP")


if __name__ == "__main__":
    num = 12
    dp = [-1 for i in range(num + 1)]
    main()
