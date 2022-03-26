package week05_homework;

/**
 * 第一题 leetcode 1011. 在 D 天内送达包裹的能力
 *
 * @author HuChao
 * @date 2022/3/25/0025 20:38
 */
public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        // 二分查找 能够送达的最小值
        int left = 0, right = 0;
        for(int weight : weights) {
            left = Math.max(left, weight); // 最大包裹重量
            right += weight; // 所有包裹重量之和
        }
        while(left < right) {
            int mid = (left + right) / 2;
            if(validate(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 判断是否能够送达
    public boolean validate(int[] weights, int days, int carry) {
        int day = 0;
        int count = 0;
        for(int weight : weights) {
            if(count + weight > carry) {
                day++;
                count = weight;
            } else {
                count += weight;
            }
        }
        return day + 1 <= days;
    }

}
