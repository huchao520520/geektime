package week05_homework;

/**
 * 第六题 leetcode 74. 搜索二维矩阵
 *
 * @author HuChao
 * @date 2022/3/25/0025 22:09
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 两次二分查找
        // 第一次找出行号
        int left = 0, right = matrix.length - 1;
        while(left < right) {
            int mid = (left + right + 1) >> 1;
            if(matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int row = right;
        // 第二次找出列号
        left = 0;
        right = matrix[0].length - 1;
        while(left < right) {
            int mid = (left + right + 1) >> 1;
            if(matrix[row][mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return matrix[row][right] == target;
    }

}
