package q2;

/**
 * Q2. 文字列を逆転させなさい。確認する文字列はどんなものでも構いません。
 *
 * <pre>
 * (例)
 * "abcde" => "edcba"
 * "酔いしれ占う仲良いあの娘" => " この愛よ叶うなら嬉しいよ"
 * </pre>
 *
 * メソッドreverseを作成しなさい。
 *
 * @author y.morinaga
 */
public class Reverse {

    public static void main(String[] args) {
        String reversed = reverse("abcde");
        System.out.println(reversed);
    }

    public static String reverse(String str) {
        int num = str.length();
        String result = "";

        for (int i = num - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

}
