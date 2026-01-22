package exam1;

public class Exam1 {
    public static void main(String[] args) {
        Car car = null;

        car = new SuperCar();
        car.setName("フェラーリ");
        car.putOnGas();
        car.run();
        car = new EcoCar();
        car.setName("プリウス");
        car.putOnGas();
        car.run();
    }
}
