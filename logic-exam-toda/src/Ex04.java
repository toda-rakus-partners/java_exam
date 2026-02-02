public class Ex04 {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);

        boolean kekka = uruu(year);

        if (kekka == true) {
            System.out.println(year + "はうるう年です");
        } else {
            System.out.println(year + "はうるう年ではありません");
        }

    }

    public static boolean uruu(int num) {
        if (num % 4 == 0 && num % 100 == 0 && num % 400 == 0) {
            return true;
        } else if (num % 4 == 0 && num % 100 == 0) {
            return false;
        } else if (num % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
