package a;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders;
    
    public OrderService(){
        orders = new ArrayList<>();
    }
    
    public OrderService addOrder(Order order){
        orders.add(order);
        return this;
    }
    
    //tinh tong tien tat ca cac order
    public double getAllBill(){
       return orders
               .stream()
               .mapToDouble((it) -> it.getBill())
               .sum();
    }
    
}
