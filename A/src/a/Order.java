
package a;

import java.util.HashMap;


public class Order {
    private final HashMap<Product,Integer> products;
    
    public Order(){
        products = new HashMap<>();
    }
        
    //mua product vs so luong quantity
    public void buyProduct(Product product,int quantity){
        products.put(product, quantity);
    }
    
    //tinh tong tien phai tra
    public double getBill(){
        return products.entrySet()
                .stream()
                .mapToDouble((or) -> or.getKey().getPrice() * or.getValue())
                .sum();    
               
    }
}
