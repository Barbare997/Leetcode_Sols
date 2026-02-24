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
        else if (p==null)
            return false;
        else if (q==null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root==null)
            return null;
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}
