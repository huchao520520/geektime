/**
 * @author HuChao
 * @date 2022/2/27/0027 18:05
 */
public class Main {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ans = plusOne.plusOne(new int[]{9, 9, 9});
        for (int an : ans) {
            System.out.print(an);
        }
    }
}
