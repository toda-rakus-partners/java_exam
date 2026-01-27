import java.util.ArrayList;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("後藤");
        list.add("山田");
        list.add("佐藤");
        list.add("田中");

        for (String name : list) {
            System.out.println(name);
        }
    }
}
