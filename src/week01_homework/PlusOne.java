package week01_homework;

/**
 * @author HuChao
 * @date 2022/2/27/0027 18:05
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            int a = digits[i] + 1;
            if(a < 10) {
                digits[i] = a;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
