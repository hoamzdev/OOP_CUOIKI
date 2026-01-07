package Chuong4.Interface;


/*
Định nghĩa một interface tên là Sellable với các phương thức:
+ getPrice() (trả về double)
+ getName() (trả về String)
+ getDescription() (trả về String)
- Tạo hai lớp triển khai Sellable là: Product (sản phẩm vật lý) và Service (dịch vụ số). Cả hai lớp có các thuộc tính riêng (tự thêm vào),
 nhưng đều triển khai các phương thức của Sellable.
- Tạo lớp ShoppingCart có một danh sách (ArrayList) để lưu các đối tượng kiểu Sellable.
- Lớp ShoppingCart có phương thức calculateTotal() để tính tổng giá trị của tất cả các mặt hàng trong giỏ hàng.
Phương thức showItems() để hiện thông tin các mặt hang trong giỏ hang.
- Trong main, tạo các đối tượng Product, Service, thêm vào giỏ hàng. Hiện thông tin về các mặt hàng và tổng tiền của các mặt hàng trong giỏ hàng
 */

import java.util.ArrayList;

interface Sellable{
    double getPrice();
    String getName();
    String getDescription();
}

class Product implements Sellable{

    private String name;
    private double price;
    private int quantity;
    private String des;

    public Product(String name, double price, String des, int quantity) {
        this.name = name;
        this.price = price;
        this.des = des;
        this.quantity = quantity;
    }

    //tong tien cua mat hang
    @Override
    public double getPrice() {
        return price * quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return des;
    }

    @Override
    public String toString() {
        return "Name :" + name + " and " + "Price :" + price + " and " + "Quantity :" + quantity + " and " + "Description :" + des;
    }
}

class Service implements Sellable{

    private String name;//ten dich vu
    private double price;//gia cua dich vu
    private String des;//mo ta dich vu

    public Service(String name, double price, String des) {
        this.name = name;
        this.price = price;
        this.des = des;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return des;
    }

    // TODO: 12/1/2025

    @Override
    public String toString() {
        return "Name :" + name + " and " + "Price :" + price + " and " + "Description :" + des;
    }
}


class ShoppingCart{
    private final ArrayList<Sellable> sellables;

    public ShoppingCart(){
        sellables = new ArrayList<>();
    }

    public void addItem(Sellable sellable){
        sellables.add(sellable);
    }

    public double calculateTotal(){
        double total = 0;
        for (Sellable sellable : sellables) {
            if (sellable instanceof Product) total += sellable.getPrice();
            else if (sellable instanceof Service) total += sellable.getPrice();
        }
        return total;
    }

    public void showItems(){
        for(Sellable sellable : sellables){
            System.out.println(sellable);
        }
    }

    //lay ra so luong item hien tai trong cart
    public int getTotalItem(){
        return sellables.size();
    }

}

public class Bai1{
    public static void main(String[] args) {
        Product product1 = new Product("hoa",100,"OMG",2);
        Product product2 = new Product("hoamz",200,"OMG",3);

        Service service1 = new Service("hoa",1000,"OMG");
        Service service2 = new Service("hoaf",5000,"OMG");


        ShoppingCart cart = new ShoppingCart();

        cart.addItem(product1);
        cart.addItem(product2);
        cart.addItem(service1);
        cart.addItem(service2);


//        System.out.println(cart.getTotalItem());//chay dc

        cart.showItems();

        System.out.println(cart.calculateTotal());

    }
}