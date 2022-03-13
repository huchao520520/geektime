package week03_homework;


/**
 * 第三题 leetcode 106. 从中序与后序遍历序列构造二叉树
 *
 * @author HuChao
 * @date 2022/3/13/0013 21:26
 */
public class BuildTree {

    int[] inorder, postorder;
    int n;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.n = postorder.length;
        return construct(0, inorder.length - 1, 0, n - 1);
    }

    /**
     * 分而治之
     */
    TreeNode construct(int inl, int inr, int pol, int por) {
        if(pol > por) return null;
        int rootval = postorder[por];
        TreeNode root = new TreeNode(rootval);
        int m = inl;
        while(inorder[m] != rootval) m++; // 找到根节点位置
        int rl = inr - m; // 右树节点数量
        root.left = construct(inl, m - 1, pol, por - rl - 1); // 左树
        root.right = construct(m + 1, inr, por - rl, por - 1); // 右树
        return root;
    }



    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
