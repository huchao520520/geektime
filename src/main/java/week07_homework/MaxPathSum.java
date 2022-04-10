package week07_homework;



/**
 * 第五题 leetcode 124. 二叉树中的最大路径和
 *
 * @author HuChao
 * @date 2022/4/10/0010 23:10
 */
public class MaxPathSum {

    int ans;

    public int maxPathSum(TreeNode root) {
         ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        ans = Math.max(ans, left + right + root.val);
        return root.val + Math.max(left, right);
    }

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
