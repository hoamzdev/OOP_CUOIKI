package a;

class Address{
    private String to;
    private String phuong;
    private String quan;
    private String thanhPho;

    public Address(String to, String phuong, String quan, String thanhPho) {
        this.to = to;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
    }

    @Override
    public String toString() {
        return to + ", " + phuong + ", " + quan + ", " + thanhPho;
    }
}

public class Customer {
    private String idCustomer;
    private String name;
    private String birthday;
    private Address address;
    
    private OrderService orderService;
    

    public Customer(String idCustomer, String name, String birthday, Address address) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }
    
    //setter

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    @Override
    public String toString() {
        return idCustomer + ", " + name + ", " + birthday + ", " + address.toString();
    }
    
    //create order service
    public OrderService createOrderService(){
        orderService = new OrderService();
        return orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
    
    
}
