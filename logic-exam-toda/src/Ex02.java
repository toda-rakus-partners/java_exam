import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex02 {
    public static void main(String[] args) {
        int[] num = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            num[i] = Integer.parseInt(args[i]);
        }

        LocalTime localTime = LocalTime.of(num[0], num[1], num[2]);

        localTime = localTime.plusSeconds(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH時mm分ss秒");
        // System.out.println(localTime.format(formatter));
        System.out.println(num[0] + "時" + num[1] + "分" + num[2] + "秒の1秒後は" + localTime.format(formatter) + "です");
    }
}
