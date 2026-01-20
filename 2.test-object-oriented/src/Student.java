public class Student {
    int energy;

    Student (int energy) {
        this.energy += energy;
    }

    void sleep() {
        this.energy += 50;

        System.out.println("寝ました。エネルギーが" + this.energy + "になりました");

        if (energy >= 100) {
            this.energy = 100;
            System.out.println("フルパワー");
        }
    }

    void study() {
        energy -= 30;

        System.out.println("勉強しました。エネルギーが" + this.energy + "になりました");

        if (energy <= 0) {
            this.energy = 0;
            System.out.println("寝てください");
        }
    }
}
