package week09_homework;

/**
 * 第八题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:25
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(!isLetter(arr[l])) {
                l++;
                continue;
            }
            if(!isLetter(arr[r])) {
                r--;
                continue;
            }
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return new String(arr);
    }

    boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
