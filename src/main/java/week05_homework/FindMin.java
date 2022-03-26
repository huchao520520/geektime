package week05_homework;

/**
 * 第五题 leetcode 154. 寻找旋转排序数组中的最小值 II
 *
 * @author HuChao
 * @date 2022/3/25/0025 21:42
 */
public class FindMin {

    public int findMin(int[] nums) {
        // 最小值左边的数 >= 右端点
        // 最小值右边的数<= 右端点
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--; // mid right值相等时,忽略right
            }
        }
        return nums[right];
    }

}
