package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SuperMarketManager {
    private HashMap<Product,Integer> store;
    private List<Customer> customers;
    
    private final Scanner sc = new Scanner(System.in);
    
    public SuperMarketManager(){
        store = new HashMap<>();
        customers = new ArrayList<>();
    }
    
    //nhap san pham vao kho
    public void importProduct(){
        //nhap product
        System.out.println("Nhập mã sản phẩm: ");
        String idProduct = sc.nextLine();
        System.out.println("Nhập tên sản phẩm:  ");
        String name = sc.nextLine();
        System.out.println("Nhập đơn giá sản phẩm: ");
        double price  = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập ngày sản xuất sản phẩm: ");
        String date = sc.nextLine();
        
        Product product = new Product(idProduct, name, price, date);
        
        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = sc.nextInt();
        //neu ton tai thi tang so luong
        store.put(product,store.getOrDefault(product,0) + quantity);
        sc.nextLine();
        System.out.println("Nhập sản phẩm thành công");

    }
    
    //add customer
    public boolean addCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
            return true;
        }
        return false;
    }
    
    
    //edit customer
    public void editCustomer(String idCustomer){
        Customer customer = (Customer) customers.stream()
                .filter((cus) -> cus.getIdCustomer().equals(idCustomer));
        
        if(customer == null){
            System.out.println("Không thấy thông tin khách hàng");
            return;
        }
        
        System.out.println("Chỉnh sửa khách hàng");
        System.out.println("1 : Sửa tên: ");
        System.out.println("2 : Sửa năm sinh: ");
        System.out.println("0 : Exit: ");
        
        while (true) {
            int type = sc.nextInt();
            switch (type) {
                case 1 -> {
                    System.out.println("Chỉnh sửa tên khách hàng: ");
                    String newName = sc.nextLine();
                    customer.setName(newName);
                }
                case 2 -> {
                    System.out.println("Chỉnh sửa ngày sinh khách hàng: ");
                    String date = sc.nextLine();
                    customer.setBirthday(date);
                }
                default -> {
                    break;
                }
            }
            
            if(type != 1 && type != 2) break;
            
        } 
        System.out.println("Edit success");
    }
    
    
    //display all product
    public void displayAllProduct(){
        store.forEach((pro,quan) -> {
            System.out.print(pro);
            System.out.println(", " + quan);
        });
    }
    
    //hien thi ds khach hang theo so tien da mua tang dan
    public void showCustomer(){
        //sort
        customers.sort((userA,userB) -> {
            if(userA.getOrderService().getAllBill() < userB.getOrderService().getAllBill()) return 1;
            else if(userA.getOrderService().getAllBill() > userB.getOrderService().getAllBill()) return -1;
            return 0;
        });
        
        //hien thi ds khach hang
        customers.forEach((it) -> {
            System.out.print(it);
            System.out.println(", " + it.getOrderService().getAllBill());
        });
    }
    
    //cap nhat lai ds mua hang cua user
    public void updateActionOfCustomer(String id,Customer c){
        int idx = -1;
        //lay indx
        for(int i=0;i<(int)customers.size();i++){
            if(customers.get(i).getIdCustomer().equals(id)){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            System.out.println("Không thấy thông tin khách hàng");
            return;
        }
        customers.set(idx, c);
    }
}
