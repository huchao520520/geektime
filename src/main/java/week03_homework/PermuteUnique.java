package week03_homework;

import java.util.*;

/**
 * 第二题 leetcode 47. 全排列 II
 *
 * @author HuChao
 * @date 2022/3/12/0012 23:26
 */
public class PermuteUnique {

    List<List<Integer>> ans;
    LinkedList<Integer> list;
    boolean[] chosen;
    Set<String> set;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        ans = new ArrayList<>();
        chosen = new boolean[n];
        list = new LinkedList<>();
        set = new HashSet<>();
        recu(nums, 0);
        return ans;
    }

    void recu(int[] nums, int i) {
        if(i == n) {
            if(!set.contains(list.toString())) {
                ans.add(new ArrayList(list));
                set.add(list.toString());
            }
            return;
        }
        for(int j = 0; j < n; j++) {
            if(!chosen[j]) {
                list.addLast(nums[j]);
                chosen[j] = true;
                recu(nums, i + 1);
                list.removeLast();
                chosen[j] = false;
            }
        }
    }

}
