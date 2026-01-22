package exam2;

public class Zoo {
    public static void main(String[] args) {
        Animal goa = new Goat();
        Animal hor = new Horse();
        Animal she = new Sheep();

        Animal[] animals = {she, hor, goa};

        for (Animal animal : animals) {
            animal.cry();
        }
    }
}
