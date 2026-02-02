public class Ex03 {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);

        int num = (year - 1) / 100 + 1;

        System.out.println(year + "は" + num + "世紀です");
    }
}
