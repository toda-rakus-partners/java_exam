import java.time.LocalDate;

public class Exam5 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2003, 2, 27);

        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        System.out.println("私の誕生日は" + year + "年" + month + "月" + day + "日" + "です");
    }
}
