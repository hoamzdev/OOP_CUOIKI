package Chuong4.Interface;

// TODO: 12/1/2025


/*
- Tạo một lớp trừu tượng (abstract class) tên là NetworkDevice với các thuộc tính chung: ipAddress, name, và một phương thức trừu tượng connect().
- Tạo một interface tên là Restartable với một phương thức duy nhất reboot() (kiểu void).
- Tạo lớp con kết hợp Router kế thừa từ lớp trừu tượng NetworkDevice và triển khai interface Restartable.
- Triển khai:
+ Router phải triển khai phương thức trừu tượng connect() (ví dụ: "Connecting to Router [IP]").
+ Router phải triển khai phương thức reboot() từ interface (ví dụ: "Rebooting Router [Name]").

Trong chương trình chính:
+ Tạo một đối tượng Router.
+ Gọi cả phương thức kế thừa: connect() và phương thức từ interface: reboot() trên đối tượng này.
+ Thử lưu trữ đối tượng này trong một tham chiếu kiểu NetworkDevice và một một tham chiếu kiểu Restartable.
 */
interface Restartable{
    void reboot();
}

abstract class NetworkDevice{

    protected String ipAddress;
    protected String name;

    public NetworkDevice(String ipAddress,String name){
        this.name = name;
        this.ipAddress = ipAddress;
    }
    abstract void connect();
}

class Router extends NetworkDevice implements Restartable{

    public Router(String ipAddress, String name) {
        super(ipAddress, name);
    }

    @Override
    void connect() {
        System.out.printf("Connecting to Router [%s]\n",ipAddress);
    }

    @Override
    public void reboot() {
        System.out.printf("Rebooting Router [%s]\n",name);
    }
}

public class Bai2 {
    public static void main(String[] args) {
//        Router router = new Router("192.168.1.1","NetM1");
//        router.connect();
//        router.reboot();
//
//        NetworkDevice networkDevice = new Router("192.168.1.1","NetM1");//upcutting
//        networkDevice.connect();
////        networkDevice.reboot();//ko goi dc o day vi trong cha (NetworkDevice ko co reboot)
//
//        Restartable restartable = new Router("192.168.1.1","NetM1");
//        restartable.reboot();
////        restartable.connect();//ko goi dc vi trong Restartable ko co phuong thuc nay

    }
}
