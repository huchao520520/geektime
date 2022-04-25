package week09_homework;

/**
 * 第二题
 *
 * @author HuChao
 * @date 2022/4/25/0025 22:47
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(ans != 0 && s.charAt(i) == ' ') return ans;
            if(s.charAt(i) != ' ') ans++;
        }
        return ans;
    }

}
