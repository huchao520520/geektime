package week09_homework;

/**
 * 第六题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:11
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] =  temp;
            l++;
            r--;
        }
    }

}
