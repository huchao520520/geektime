package week05_homework;

/**
 * 第三题 leetcode 875. 爱吃香蕉的珂珂
 *
 * @author HuChao
 * @date 2022/3/25/0025 21:33
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        // 找到能吃完香蕉的最小速度
        int left = 0, right = 1000000000;
        // for(int pile : piles) right = Math.max(right, pile);
        while(left < right) {
            int mid = (left + right) >> 1;
            if(validate(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 验证速度 speed 是否能吃完香蕉
    boolean validate(int[] piles, int h, int speed) {
        int hour = 0;
        int count = 0;
        for(int pile : piles) {
            hour += Math.ceil(pile * 1.0 / speed); // 吃完每堆香蕉需要的小时数
        }
        return hour <= h;
    }

}
