package week06_homework;

import java.util.List;

/**
 * 第二题 leetcode 120. 三角形最小路径和
 *
 * @author HuChao
 * @date 2022/4/3/0003 20:51
 */
public class MinimumTotal {

    /**
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     */

    /**
     * 11
     * 9 10
     * 7 6 10
     * 4 1 8 3
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int[] f = new int[lastRow.size()];
        for (int i = 0; i < lastRow.size(); i++) {
            f[i] = lastRow.get(i);
        }
        // 从下往上
        for(int i = triangle.size() - 2; i >= 0; i--) {
            // 从左往右
            for(int j = 0; j < triangle.get(i).size(); j++) {
                // 状态更改  下一行相邻较小 + 自身
                f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }

}
