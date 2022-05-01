package week10_homework;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 第一题 leetcode 239. 滑动窗口最大值
 *
 * @author HuChao
 * @date 2022/5/1/0001 10:07
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
            if (i >= k - 1) {
                while(treeMap.firstEntry().getValue() <= i - k) {
                    treeMap.pollFirstEntry();
                }
                ans[i - k + 1] = treeMap.firstEntry().getKey();
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {

        }
        return ans;
    }
}
