package week04_homework;

/**
 * 第三题 leetcode 538. 把二叉搜索树转换为累加树
 *
 * @author HuChao
 * @date 2022/3/20/0020 17:02
 */
public class ConvertBST {

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

    // 反序中序遍历， 即倒序遍历（从大到小）
    // 用一个全局变量对遍历到的数求和，即为原树中大于或等于 node.val 的值之和
    // 8 7  6  5  4  3  2  1  0
    // 8 15 21 26 30 33 35 36 36
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
