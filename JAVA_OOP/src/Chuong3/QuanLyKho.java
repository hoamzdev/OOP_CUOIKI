package Chuong3;

import java.util.Objects;

class Product{
    private final String productId;
    private String name;
    private double price;
    private int quantity;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateQuantity(int change){
        quantity += change;
    }

    @Override
    public String toString() {
        return productId + "  " + name + "  " + price + "  " + quantity;
    }
}

class InventoryManager{

    private static final int MAX_PRODUCTS = 20;
    private static Product[] inventory= new Product[MAX_PRODUCTS];
    private static int productCount = 0;

    private static boolean _addProduct(String productId,String name,double price){
        if(productCount < MAX_PRODUCTS){
            for(int i=0;i<productCount;i++){
                if(Objects.equals(inventory[i].getProductId(), productId)){
                    return false;
                }
            }
            Product product = new Product(productId,name,price);
            inventory[productCount++] = product;
            return true;
        }
        return false;
    }

    public static void addProduct(String productId,String name,double price){
        if(_addProduct(productId,name,price)){
            System.out.println("Them thanh cong");
        }
        else System.out.println("San pham da ton tai");
    }

    public static Product findProductById(String productId){
        Product product = null;
        for(int i=0;i<productCount;i++){
            if(inventory[i].getProductId().equals(productId)){
                product = inventory[i];
                break;
            }
        }
        return product;
    }

    public static void updateProductQuantity(String productId,int change){
        for(int i=0;i<productCount;i++){
            if(inventory[i].getProductId().equals(productId)){
                inventory[i].updateQuantity(change);
                break;
            }
        }
    }

    public static void displayInventory(){
        for(int i=0;i<productCount;i++){
            System.out.println(inventory[i]);
        }
    }
}

class Store{
    public static void main(String[] args) {
        InventoryManager.addProduct("XXX","QWERT",1000);
        InventoryManager.addProduct("YYY","QWERT",3000);
        InventoryManager.addProduct("ZZZ","QWERT",5000);

        //hien thi ds sp
        InventoryManager.displayInventory();
        //cap nhat so luong sp
        InventoryManager.updateProductQuantity("XXX",2);
        //in lai ket qua
        InventoryManager.displayInventory();
        //tim kiem san pham
        Product res =  InventoryManager.findProductById("XXX");
        if(res == null) System.out.println("Khong tim thay sp");
        else System.out.println(res);
    }
}