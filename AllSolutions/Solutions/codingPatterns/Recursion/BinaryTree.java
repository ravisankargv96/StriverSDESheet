package Solutions.codingPatterns.Recursion;

public class BinaryTree {

    // check all these solutions once. It has lots of edge cases.
    // perform this immediately.
    // Take build tree as verification purpose
    // BTInOrderPostOrder() pointers are wrong. getting a stack overflow exception.

    public int LeftRootRight(int n){

        if(n == 1 || n == 0){
            return n;
        }

        // Standing in this node
        // do something
        int left = LeftRootRight(n-1); // left subproblem

        // do something

        int right = LeftRootRight(n-2); // right subproblem
        // do something

        return left + right;
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

    public boolean hasPathSum(TreeNode root, int sum, int target){

        if(root == null){
            return sum == target;
        }

        boolean left = hasPathSum(root.left, sum + root.val, target);
        boolean right = hasPathSum(root.right, sum + root.val, target);

        return left || right;
    }

    public TreeNode BTInOrderPostOrder(int[] inorder, int inSt, int inEnd,
                                       int[] postorder, int postSt, int postEnd){

        if(inSt > inEnd){
            return null;
        }

        int rootVal = postorder[postEnd];

        TreeNode root = new TreeNode(rootVal);

        int count = 0;
        for(int i = inSt; i <= inEnd; i++){
            if(inorder[i] == rootVal){
                break;
            }
            count++;
        }

        //get the ranges clearly.

        TreeNode left = BTInOrderPostOrder(inorder,inSt,inSt + count-1, postorder, postSt, postEnd + count-1);
        TreeNode right = BTInOrderPostOrder(inorder,inSt + count + 1, inEnd, postorder, postSt + count + 1, postEnd);

        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE){
        if(inS>inE || posS>posE) return  null;

        TreeNode root = new TreeNode(postorder[posE]);

        int rootI=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootI = i;
                break;
            }
        }

        root.left = build(inorder,inS,rootI-1,postorder,posS,posS+rootI-inS-1);
        root.right = build(inorder,rootI+1,inE,postorder,posS+rootI-inS,posE-1);

        return root;
    }

    public TreeNode SortedArrayToBST(int[] arr, int low, int high){

        if(low > high){
            return null;
        }

        int mid = low - (low - high)/2;
        TreeNode root = new TreeNode(arr[mid]);

        TreeNode left = SortedArrayToBST(arr,low,mid-1);
        TreeNode right = SortedArrayToBST(arr,mid+1,high);

        root.left = left;
        root.right = right;

        return root;
    }

    public int minimumDepthOfBT(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = minimumDepthOfBT(root.left);
        int right = minimumDepthOfBT(root.right);

        return Math.min(left,right) + 1;
    }

    public int BTMaximumPathSum(TreeNode root,int maxSum){

        if(root == null){
            return 0;
        }

        int left = Math.max(BTMaximumPathSum(root.left,maxSum),0);
        int right = Math.max(BTMaximumPathSum(root.right,maxSum),0);

        int value = left + right + root.val;
        maxSum = Math.max(maxSum,value);

        //considering non-zero pathSum
        return Math.max(left,right) + root.val;
    }

    //internally implementing height logic
    public int balancedBT(TreeNode root, boolean isBalanced){

        if(root == null){
            return 0;
        }

        int left = balancedBT(root.left,isBalanced);
        int right = balancedBT(root.right,isBalanced);

        boolean isBalnode = Math.abs(left - right) <= 1 ? true : false;
        isBalanced = isBalanced && isBalnode;

        return Math.max(left,right) + 1;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return true;
        }

        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        boolean leftBranch = isSymmetric(left.left,left.right);
        boolean rightBranch = isSymmetric(right.left,right.right);

        return leftBranch && rightBranch;
    }

    public static void main(String[] args) {

    }
}
