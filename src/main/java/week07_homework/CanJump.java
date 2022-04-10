package week07_homework;

/**
 * 第二题 leetcode 55. 跳跃游戏
 *
 * @author HuChao
 * @date 2022/4/10/0010 22:38
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int next = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= next) {
                next = Math.max(next, i + nums[i]); // 每次贪心地走最远长度
                if(next >= nums.length - 1) return true; // 下个位置可走到重点
            }
        }
        return false;
    }

}
