package a;

public class A {

    public static void main(String[] args) {
        SuperMarketManager manager = new SuperMarketManager();
//        manager.importProduct();
//        manager.importProduct();
        
//        gia su co 1 khach hang ten la hoa
        Customer hoa = new Customer("ID01", "Hoa", "26/12/2025",
                new Address("1", "VQ", "Ha Dong", "HN"));
        
        manager.addCustomer(hoa);//them vao ds kh cua sieu thi
        
        //fake product
        Product p1 = new Product("CT1", "Bim Bim", 10000, "26/12/2026");
        Product p2 = new Product("CT2", "Bim A", 10000, "26/12/2026");
        Product p3 = new Product("CT3", "Bim Cim", 30000, "26/12/2026");
        Product p4 = new Product("CT4", "Bim Tim", 60000, "26/12/2026");
        
        Order o = new Order();
        o.buyProduct(p4, 5);
                
        double bill = hoa.createOrderService()
                .addOrder(o)
                .getAllBill();
        
        System.out.println(bill);
        
       
        
        
        //gia su co 1 khach hang ten la hwa
        Customer hwa = new Customer("ID02", "Hwa", "21/12/2025",
                new Address("2", "VQ", "Ha Dong", "HN"));
        
        manager.addCustomer(hwa);
        
        Order o1 = new Order();
        o1.buyProduct(p1, 5);
                
        double billHwa = hwa.createOrderService()
                .addOrder(o1)
                .getAllBill();
        
        System.out.println(billHwa);
        
        
        
        
        
        manager.showCustomer();
        
    }

}
