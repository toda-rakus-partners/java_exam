package exam1;

public class Car {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }     
    void putOnGas() {
        System.out.println(getName() + "に給油します");
    }

    void run() {
        System.out.println("ブーン!車が走ります");
    }
}
