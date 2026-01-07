package a;


public class Product {
    private String idProduct;
    private String nameProduct;
    private double price;
    private String date;

    public Product(String idProduct, String nameProduct, double price, String date) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.date = date;
    }
    

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }     

    @Override
    public String toString() {
        return idProduct + ", " + nameProduct + ", " + price + ", " + date;
    }
    
    
    
}
