package week09_homework;

/**
 * 第九题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:35
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int[] sarr = new int[256];
        int[] tarr = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)]) return false;
            sarr[(int)s.charAt(i)] = i + 1;
            tarr[(int)t.charAt(i)] = i + 1;
        }
        return true;
    }

}
