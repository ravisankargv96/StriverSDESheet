from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def generate(a, b, c, aa, bb, cc):

    if(a < b):
        return generate(b, a, c, bb, aa, cc)
    if(b < c):
        return generate(a, c, b, aa, cc, bb);
    if(b == 0):
        return aa*(min(2,a));

    use_a = min(2,a)
    use_b = 1  if(a - use_a >= b)  else 0;

    return aa*(use_a) + bb*(use_b) + generate(a - use_a, b - use_b, c, aa, bb, cc);


def main():
    # Call function
    a = 1
    b = 1
    c = 7
    print(generate(a,b,c,'a','b','c'))
    # Save recursion tree to a file
    save("happyString")


if __name__ == "__main__":
    main()
