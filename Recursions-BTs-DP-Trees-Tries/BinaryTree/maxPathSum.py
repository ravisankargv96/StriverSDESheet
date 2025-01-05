import sys
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
def maxPathSum(root,maxSum):

    if (root == None):
        return 0

    left = maxPathSum(root.left,maxSum)
    right = maxPathSum(root.right,maxSum)

    sum = max(left,0) + max(right,0) + root.data;

    maxSum[0] = max(maxSum[0],sum);

    return root.data + max( max(left,0), max(right,0))

def main():

    #arr = [1,3,2,5,"#","#",4,7,"#","#",6]
    #arr = [5,2,1,"#",10,3,4,"#","#",8,11,"#"]
    arr = [-10,9,20,"#","#",15,7]
    bt = deserialize(arr)
    maxSum = [-1000000000000]
    print(maxPathSum(bt,maxSum))
    print("maxSum value is:",maxSum[0])

    save("maxPathSumOfBinaryTree")


if __name__ == "__main__":
    main()
