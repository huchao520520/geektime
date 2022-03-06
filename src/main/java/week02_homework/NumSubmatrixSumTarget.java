package week02_homework;

/**
 * 第三题 leetcode 1074. 元素和为目标值的子矩阵数量
 *
 * @author HuChao
 * @date 2022/3/6/0006 22:10
 */
public class NumSubmatrixSumTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int[] sum = new int[m];
            for(int j = i; j< n; ++j) {
                for(int k = 0; k < m; ++k) {
                    sum[k] += matrix[j][k];
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1]; // 前缀和数组
        sum[0] = 0;
        int ans = 0;
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            if(nums[i-1] == k) ans++; // 数组中的数 == k时， 加1
        }
        for(int i = 1; i < sum.length; i++) {
            for(int j = i + 1; j < sum.length; j++) {
                if(sum[j] - sum[i-1] == k) ans++; // 子数组和 == k 时，加1
            }
        }
        return ans;
    }

}
