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
def isSame(node1,node2):

    if (node1 == None and node2 == None):
        return True

    if((node1 != None and node2 == None) or (node1 == None and node2 != None)):
        return False

    if(node1.data != node2.data):
        return False

    left = isSame(node1.left,node2.left)
    if (not left):
        return False

    right = isSame(node1.right,node2.right)
    if (not right):
        return False

    return left and right


def main():

    #arr = [1,3,2,5,"#","#",4,7,"#","#",6]
    #arr = [5,2,1,"#",10,3,4,"#","#",8,11,"#"]
    #arr = [4,7,8,"#","#",1,0,3,"#",2,11,5,"#",0,"#","#","#"]
    #arr = [1,2,3,4,5,6,7,"#","#","#","#","#","#","#","#"]
    arr1 = [1,2,3,"#","#",4,5]
    arr2 = [1, 2, 3, "#", "#", 4, 5]
    bt1 = deserialize(arr1)
    bt2 = deserialize(arr2)
    print(isSame(bt1,bt2))

    save("IdenticalBinaryTrees")


if __name__ == "__main__":
    main()
