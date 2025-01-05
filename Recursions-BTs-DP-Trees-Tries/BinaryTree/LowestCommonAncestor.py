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
def LCA(root,nodeP,nodeQ):

    if (root == None or root == nodeP or root == nodeQ):
        return root

    left = LCA(root.left,nodeP,nodeQ)
    right = LCA(root.right,nodeP,nodeQ)

    if (left == None):
        return right;
    elif(right == None):
        return left;
    else:
        return root;

def main():

    #arr = [1,3,2,5,"#","#",4,7,"#","#",6]
    #arr = [5,2,1,"#",10,3,4,"#","#",8,11,"#"]
    #arr = [4,7,8,"#","#",1,0,3,"#",2,11,5,"#",0,"#","#","#"]
    arr = [1,2,3,4,5,6,7,"#","#","#","#","#","#","#","#"]
    maxDia = [0]
    bt = deserialize(arr)
    print(LCA(bt,bt.left.left,bt.left.right))

    save("LowestCommonAncestorOfBT")


if __name__ == "__main__":
    main()
