import java.util.HashMap;
import java.util.Map;

public class Exam4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("東京", "東京");
        map.put("埼玉", "さいたま");
        map.put("茨城", "水戸");
        map.put("沖縄", "那覇");

        System.out.println("埼玉の県庁所在地は" + "「" + map.get("埼玉") + "」です");
        System.out.println("沖縄の県庁所在地は" + "「" + map.get("沖縄") + "」です");
    }
}
