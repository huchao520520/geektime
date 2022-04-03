package week06_homework;

/**
 * 第一题 leetcode 70. 爬楼梯
 *
 * @author HuChao
 * @date 2022/4/3/0003 22:03
 */
public class ClimbStairs {

    /**
     * 台阶数 ：1 2 3 4 5 6  7
     * 方法数 ：1 2 3 5 8 13 21
     * 从第三阶开始
     * f(i) = f(i - 1) + f(i - 2)
     */

    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] p = new int[n];
        p[0] = 1;
        p[1] = 2;
        for(int i = 2; i < n; i++) {
            p[i] = p[i - 1] + p[i - 2];
        }
        return p[n - 1];
    }

}
