public class Exam1 {
    public static void main(String[] args) {
        int totalScore = 79;

        if (totalScore >= 0 && totalScore <= 79) {
            System.out.println("追試です");
        } else if (totalScore >= 80 && totalScore <= 99) {
            System.out.println("合格です");
        } else if (totalScore == 100) {
            System.out.println("満点です");
        } else {
            System.out.println("存在しない点数です");
        }
    }
}
