public class TreeSolutions {
    //Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root==null)
            return null;
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }

    //Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return isSameTree(invertTree(root.right), root.left);
    }

    public boolean isSymmetric1 (TreeNode root) {
        if (root==null)
            return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror (TreeNode left, TreeNode right) {
        if (left==null && right==null)
            return true;
        else if (left==null || right==null)
            return false;
        return left.val==right.val && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    //Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)
            return null;
        if (root.val==val)
            return root;
        else if (val>root.val)
            return searchBST (root.right, val);
        else return searchBST(root.left, val);
    }
}
