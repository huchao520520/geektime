package week02_homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第二题： leetcode 697. 数组的度
 *
 * @author HuChao
 * @date 2022/3/6/0006 21:42
 */
public class FindShortestSubArray {

    @Test
    public void test() {
        int shortestSubArray = findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
        System.out.println("shortestSubArray = " + shortestSubArray);
    }

    public int findShortestSubArray(int[] nums) {
        // Map<数组中的数字， 数字出现的下标集合>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> idxs = map.get(nums[i]);
            if(idxs != null) {
                idxs.add(i);
            } else {
                idxs = new ArrayList<>();
                idxs.add(i);
                map.put(nums[i], idxs);
            }
        }
        int ans = 50001; // 记录答案
        int du = 0; // 记录度
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> idxs = entry.getValue();
            int currdu = idxs.size(); // 下表集合的长度即为该数出现次数
            if(currdu == du) { // 相等说明有多个数出现次数一样
                ans = Math.min(ans, idxs.get(currdu - 1) - idxs.get(0) + 1);
            } else if(currdu > du) { // 大于则更新du，并更新答案
                du = currdu;
                ans = idxs.get(currdu - 1) - idxs.get(0) + 1;
            }
        }
        return ans;
    }

}
