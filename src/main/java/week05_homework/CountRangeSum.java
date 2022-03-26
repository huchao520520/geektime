package week05_homework;

/**
 * 第四题 leetcode 327. 区间和的个数
 *
 * @author HuChao
 * @date 2022/3/25/0025 21:35
 */
public class CountRangeSum {

    int ans;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 前缀和数组，任意两值之差为一个区间和
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        ans = 0;
        this.lower = lower;
        this.upper = upper;
        mergeSort(sum, 0, sum.length - 1);
        return ans;
    }

    void mergeSort(long[] arr, int left, int right) {
        if(left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        calculate(arr, left, mid, right);
        mergeTwo(arr, left, mid, right);
    }

    // 计算本层符合要求的区间和个数
    void calculate(long[] arr, int left, int mid, int right) {
        int l = mid + 1, r = mid + 1;
        for(int i = left; i <= mid; i++) {
            while(l <= right && arr[l] - arr[i] < lower) l++;
            while(r <= right && arr[r] - arr[i] <= upper) r++;
            ans += (r - l);
        }
    }

    void mergeTwo(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1;
        int count = 0;
        while(i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[count] = arr[i];
                i++;
            } else {
                temp[count] = arr[j];
                j++;
            }
            count++;
        }
        while(i <= mid) {
            temp[count] = arr[i];
            i++;
            count++;
        }
        while(j <= right) {
            temp[count] = arr[j];
            j++;
            count++;
        }
        for(int k = 0; k < right - left + 1; k++) {
            arr[k + left] = temp[k];
        }
    }
}
