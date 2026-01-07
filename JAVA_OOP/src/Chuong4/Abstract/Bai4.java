package Chuong4.Abstract;

/*
Tạo lớp TaiKhoan với các thuộc tính: soTaiKhoan (String), tenChuTaiKhoan (String), soDu (double).
- Tạo các phương thức napTien(double soTien), rutTien(double soTien), và kiemTraSoDu(). Phương thức rutTien nên kiểm tra xem số dư có đủ không.
- Tạo lớp TaiKhoanTietKiem kế thừa từ TaiKhoan, thêm thuộc tính laiSuat (double) và phương thức tinhLai().
- Tạo lớp TaiKhoanVay cũng kế thừa từ TaiKhoan, thêm thuộc tính hanMucVay (double). Ghi đè phương thức rutTien để cho phép rút tiền vượt quá số dư nhưng không vượt quá hạn mức vay.
- Viết chương trình để kiểm tra hoạt động của các loại tài khoản khác nhau.
 */

abstract class TaiKhoan{

    private String soTaiKhoan;
    private String tenChuTaiKhoan;
    protected double soDu;

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien){
        soDu += soTien;
    }

    public void rutTien(double soTienCanRut){
        //neu co the rut -> rut
        if(kiemTraSoDu(soTienCanRut)){
            this.soDu -= soTienCanRut;
        }
        else{
            System.out.println("Tai khoan khong du so du");
        }
    }

    public double getSoDu() {
        return soDu;
    }

    private boolean kiemTraSoDu(double soTienCanRut){
        return this.soDu >= soTienCanRut;
    }
}

class TaiKhoanTietKiem extends TaiKhoan{

    private double laiSuat;//???? lai xuat / mot nam ??
    public TaiKhoanTietKiem(String soTaiKhoan, String tenChuTaiKhoan, double soDu,double laiSuat) {
        super(soTaiKhoan, tenChuTaiKhoan, soDu);
        this.laiSuat = laiSuat;
    }

    //tinh lai sau 1 nam
    private double tinhLai(){
        return soDu * laiSuat;
    }

    //so du sau lai
    @Override
    public double getSoDu() {
        return soDu + tinhLai();
    }
}

class TaiKhoanVay extends TaiKhoan{

    private double hanMucVay;
    public TaiKhoanVay(String soTaiKhoan, String tenChuTaiKhoan, double soDu,double hanMucVay) {
        super(soTaiKhoan, tenChuTaiKhoan, soDu);
        this.hanMucVay = hanMucVay;
    }

    @Override
    public void rutTien(double soTienCanRut) {
        if(soTienCanRut > soDu){
            //binh thuong se khong rut dc -> vay
            if(soTienCanRut - soDu < hanMucVay){
                //->vay
                soDu -= soTienCanRut;
            }
        }
        else{
            soDu -= soTienCanRut;
        }
    }
    //lay ra so tien dang no neu sd vay
    public void soTienDangVay(){
        if(getSoDu() < 0) System.out.println("Dang vay : " + getSoDu() * -1);
        else System.out.println("Khong co khoan vay nao");
    }
}

public class Bai4 {
    public static void main(String[] args) {
//        TaiKhoanTietKiem userA = new TaiKhoanTietKiem("01234","HOA",1000000,0.1);
//        userA.rutTien(500000);
//        System.out.println(userA.getSoDu());

        TaiKhoanVay userB = new TaiKhoanVay("01234","HOA",1000000,5000000);
        userB.rutTien(1000000);
        System.out.println(userB.getSoDu());
        userB.soTienDangVay();
    }
}
