import java.util.HashMap;
import java.util.Map;

public class Ex05 {
    public static void main(String[] args) {
        String[] strs = {"soccer", "baseball", "jogging", "jogging", "soccer", "surfing", "surfing", "soccer", "surfing", "baseball", "boxing", "surfing", "soccer", "surfing", "jogging", "boxing", "jogging", "baseball", "soccer", "soccer"};
        int soccerNo = 0;
        int baseballNo = 0;
        int joggingNo = 0;
        int surfingNo = 0;
        int boxingNo = 0;
        
        for (String str : strs) {
            if (str.equals("soccer")) {
                soccerNo++;
            } else if (str.equals("baseball")) {
                baseballNo++;
            } else if (str.equals("jogging")) {
                joggingNo++;
            } else if (str.equals("surfing")) {
                surfingNo++;
            } else if (str.equals("boxing")) {
                boxingNo++;
            } else {}
        }

        Map<String, Integer> map = new HashMap<>();
        map.put(null, null);
        int max = soccerNo;

        if (max < baseballNo) {
            max = baseballNo;
            map.put("baseball", max);
        }

        if (max < joggingNo) {
            max = joggingNo;
            map.put("jogging", max);
        }

        if (max < surfingNo) {
            max = surfingNo;
            map.put("surfing", max);
        }

        if (max < boxingNo) {
            max = boxingNo;
            map.put("boxing", max);
        }

        
        
        System.out.println("最も出現回数の多いスポーツは" + "" + "で、出現回数は" + max + "回です");
    }
}
