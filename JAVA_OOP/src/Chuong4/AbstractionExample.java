package Chuong4;

abstract class Shape{
    String color;
    
    public Shape(String color){
        this.color = color;
    }
   
    public void displayColor(){
        System.out.println("Màu sắc của hình là: " + color);
    }
    
    public abstract double tinhDienTich();    
    
    public void phuongThucCuaShape(){
        System.out.println("hwa");
    }
    
    int getNumber(){
        return 10;
    }
}

class Circle extends Shape{
    double radius;

    public Circle(String color,double radius){
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double tinhDienTich() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    double width,height;
    
    public Rectangle(String color,double width,double height){
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double tinhDienTich() {
        return width * height;
    }
    public void phuongThucCuaRec(){
        System.out.println("hoa");
    }
}

public class AbstractionExample{
    public static void main(String[] args) {
//        Circle circle = new Circle("Hong", 2);
//        circle.displayColor();//neu ko ghi de thi no se goi thang cha gan nhat cua no

        Shape shape = new Rectangle("Hong", 2, 3);//upcuting
        System.out.println(shape.tinhDienTich());
        shape.phuongThucCuaShape();
        System.out.println(shape.getNumber());
    }
}