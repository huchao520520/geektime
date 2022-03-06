package week02_homework;

/**
 * 第四题 leetcode 560. 和为 K 的子数组
 *
 * @author HuChao
 * @date 2022/3/6/0006 22:36
 */
public class SubarraySum {

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
