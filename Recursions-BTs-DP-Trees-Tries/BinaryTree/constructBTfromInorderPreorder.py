
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

@vs(show_return_value=True,node_properties_kwargs={"shape": "record", "color": "#f57542", "style": "filled", "fillcolor": "grey"})
def BT(inOrder,inStart,inEnd,preOrder,preStart,preEnd):

    if (inStart > inEnd):
        return None

    node = TreeNode([preStart])

    ind = inStart;
    while(inOrder[ind] != preOrder[preStart]):
        ind += 1

    leftSideElements = ind - inStart
    rightSideElements = inEnd - ind;

    left = BT(inOrder,inStart,ind-1,preOrder,preStart+1,preStart + leftSideElements)
    right = BT(inOrder,ind+1,inEnd,preOrder,preStart + leftSideElements+1,preEnd)

    node.left = left
    node.right = right
    return node;

def main():

    inorder = [40,20,50,10,60,30]
    preorder = [10,20,40,50,30,60]

    print(BT(inorder,0,len(inorder)-1,preorder,0,len(preorder)-1))

    save("BTConstructionFromInorderAndPreorder")


if __name__ == "__main__":
    main()
