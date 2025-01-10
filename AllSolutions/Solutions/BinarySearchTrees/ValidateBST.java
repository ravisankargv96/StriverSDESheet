package Solutions.BinarySearchTrees;

public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean validateBST(TreeNode root, long min, long max){

        if(root == null){
            return true;
        }

        // root value not in range (standing in the node)
        if((long)root.val <= min  || max <= (long)root.val){
            return false;
        }

        boolean left = validateBST(root.left,min,root.val);
        boolean right = validateBST(root.right,root.val,max);

        return left && right;
    }
}
