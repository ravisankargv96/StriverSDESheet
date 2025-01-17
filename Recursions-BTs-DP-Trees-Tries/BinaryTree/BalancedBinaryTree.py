from collections import deque

from visualiser.visualiser import Visualiser as vs

def save(filename):
    dir = r"..\Images\BinaryTree"
    file = dir +"\\" + filename
    vs.make_animation(file, delay=1)

class TreeNode:

    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

    # shows object value if written str(obj)
    def __str__(self):
        return f'{self.data}'

    # used for the visualizer to show object value
    def __repr__(self):
        return f'{self.data}'

def deserialize(data):
    if not data: return []
    root = TreeNode(data[0])
    i = 1
    queue = deque([root])
    while queue and i <= len(data) - 1:
        node = queue.popleft()
        if data[i] != '#':
            left = TreeNode(data[i])
            node.left = left
            queue.append(left)
        i += 1
        if i > len(data) - 1:
            break
        if data[i] != '#':
            right = TreeNode(data[i])
            node.right = right
            queue.append(right)
        i += 1
    return root

@vs(show_return_value=True,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def height(root):

    if not root:
        return 0

    left = height(root.left)
    if(left == -1):
        return -1;

    right = height(root.right)
    if(right == -1):
        return -1;

    if(abs(left - right) > 1):
        return -1;

    return 1 + max(left,right)

def main():

    #arr = [1,3,2,5,"#","#",4,7,"#","#",6]
    #arr = [5,2,1,"#",10,3,4,"#","#",8,11,"#"]
    arr = [4,7,8,"#","#",1,0,3,"#",2,11,5,"#",0,"#","#","#"]
    maxDia = [0]
    bt = deserialize(arr)
    print("If returns -1 it's not balancedBT, returns value > 0 its balanced one", height(bt))

    save("BalancedBinaryTree")


if __name__ == "__main__":
    main()
