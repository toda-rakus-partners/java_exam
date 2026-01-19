public class Exam6 {
    public static void main(String[] args) {
        int sum = calc(1, 1, '-');
        System.out.println(sum);
    }

    public static int calc(int num1, int num2, char str) {
        if (str == '+' || str == '-' || str == '*' || str == '/') {
            return num1 + str + num2;
        } else {
            return -1;
        }
    }
}
