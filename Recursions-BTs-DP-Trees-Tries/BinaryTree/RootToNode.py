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
def hasPath(root,arr,x):

    if not root:
        return False

    arr.append(root.data)

    if(root.data == x):
        return True

    left = hasPath(root.left,arr,x)
    if(left):
        return True

    right = hasPath(root.right,arr,x)
    if(right):
        return True

    arr.pop(len(arr)-1)
    return False


def main():

    arr = [1,2,3,"#","#",4,5]
    bt = deserialize(arr)

    hasPath(bt,[],5)
    save("RootToNode")


if __name__ == "__main__":
    main()
