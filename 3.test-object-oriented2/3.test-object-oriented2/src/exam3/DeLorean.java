package exam3;

public class DeLorean implements Airplane, Car, TimeMachine{
    public void run() {
        System.out.println("デロリアンが走る！");
    }

    public void fly() {
        System.out.println("デロリアンが飛ぶ！");
    }

    public void timeTravel() {
        System.out.println("デロリアンがタイムテレポート！");
    }

    public void engineStart() {
        DeLorean del = new DeLorean();
        del.run();
        del.fly();
        del.timeTravel();
    }
}
