public class Exam3 {
    public static void main(String[] args) {
        int item1 = 200;
        int item2 = 250;
        int syoukei = item1 * 3 + item2 * 4;
        int syouhizei = syoukei / 10;
        int total = syoukei + syouhizei;

        System.out.println("小計\n" + syoukei);
        System.out.println("消費税\n" + syouhizei);
        System.out.println("合計金額\n" + total);
    }
}
