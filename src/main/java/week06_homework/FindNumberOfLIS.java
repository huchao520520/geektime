package week06_homework;

import org.junit.Test;

/**
 * 第三题 leetcode 673. 最长递增子序列的个数
 *
 * @author HuChao
 * @date 2022/4/3/0003 21:56
 */
public class FindNumberOfLIS {

    @Test
    public void test() {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, ans = 0, max = 0;
        int[] p = new int[n];
        int[] q = new int[n];
        for(int i = 0; i < n; i++) {p[i] = 1; q[i] = 1;}
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(p[j] + 1 > p[i]) {
                        p[i] = p[j] + 1;
                        q[i] = q[j];
                    }else if(p[j] + 1 == p[i]) {
                        q[i] += q[j];
                    }
                }
            }
            if(p[i] > max) {max = p[i]; ans = q[i];}
            else if(p[i] == max) ans += q[i];
        }
        return ans;
    }
}
