package Chuong3;

class Engine{
    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public void start(){
        System.out.println("Động cơ " + type + " khởi động với " + horsepower + " mã lực");
    }
}

public class Car {

    private String brand;//hang xe
    private Engine engine;//dong co

    public Car(String brand_,Engine engine_){
        brand = brand_;
        engine = engine_;
    }

    public void startCar(){
        System.out.println("Xe " + brand + " Dang khoi dong... ");
        engine.start();
    }
}
