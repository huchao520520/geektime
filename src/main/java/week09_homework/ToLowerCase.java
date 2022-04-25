package week09_homework;

/**
 * 第一题
 *
 * @author HuChao
 * @date 2022/4/24/0024 21:10
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] = (char)(chs[i] - 'A' + 'a');
            }
        }
        return new String(chs);
    }

}
