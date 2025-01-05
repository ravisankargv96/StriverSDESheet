from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r".\Images"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

@vs(show_return_value=False,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def subset(nums,sum,ans):

    if(len(nums) == 0):
        ans.append(sum)
        return
    
    subset(nums[1:], sum ,ans)
    subset(nums[1:], sum + nums[0] ,ans)


def main():
    # Call function
    nums = [1,2,3]
    sum = 0
    ans=[]

    print(subset(nums,sum,ans))
    # Save recursion tree to a file
    save("test_subsets")


if __name__ == "__main__":
    main()
