package week07_homework;

/**
 * 第三题 leetcode 45. 跳跃游戏 II
 *
 * @author HuChao
 * @date 2022/4/10/0010 22:40
 */
public class Jump {

    public int jump(int[] nums) {
        int ans = 0;
        int i = 0;
        while(i < nums.length - 1) {
            int cur = nums[i];
            if(i + cur >= nums.length - 1) return ans + 1;
            int nextNext = i;
            int next = i + cur;
            for(int j = i + 1; j <= i + cur; j++) {
                if(j + nums[j] > nextNext) {
                    nextNext = j + nums[j];
                    next = j;
                }
            }
            i = next;
            ans++;
        }
        return ans;
    }
}
