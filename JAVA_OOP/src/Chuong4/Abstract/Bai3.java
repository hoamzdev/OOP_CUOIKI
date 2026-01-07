package Chuong4.Abstract;


/*
- Tạo lớp PhuongTien với các thuộc tính cơ bản (tên, hãng sản xuất, năm sản xuất, vận tốc tối đa) và phương thức hienThiThongTin().
- Tạo lớp Oto và XeMay kế thừa từ PhuongTien.
- Trong lớp Oto, thêm thuộc tính số chỗ ngồi và loại nhiên liệu.
- Trong lớp XeMay, thêm thuộc tính công suất động cơ.
- Ghi đè phương thức hienThiThongTin() ở các lớp con để hiển thị đầy đủ chi tiết của từng loại phương tiện.
- Sử dụng đa hình (polymorphism) bằng cách lưu trữ các đối tượng Oto và XeMay trong một mảng kiểu PhuongTien và duyệt qua mảng để hiển thị thông tin.
 */

abstract class PhuongTien{

    public static int soLuongPhuongTien = -1;//lam index cho mang

    private String ten;
    private String hangSanXuat;
    private int namSanXuat;
    private double vanTocToiDa;//tinh theo km/h

    //cons
    public PhuongTien(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa) {
        this.ten = ten;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.vanTocToiDa = vanTocToiDa;
    }

    public void hienThiThongTin(){
        System.out.print(ten + " " + hangSanXuat + " " + namSanXuat + " " + vanTocToiDa + " ");
    }
}

class Oto extends PhuongTien{

    private int soChoNgoi;
    private String loaiNhienLieu;

    //cons
    public Oto(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa,int soChoNgoi,String loaiNhienLieu) {
        super(ten, hangSanXuat, namSanXuat, vanTocToiDa);
        this.soChoNgoi = soChoNgoi;
        this.loaiNhienLieu = loaiNhienLieu;
        PhuongTien.soLuongPhuongTien++;
    }

    //impl method hienThiThongTin
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();//goi cha no
        //ghi de them
        System.out.println(soChoNgoi + " " + loaiNhienLieu);
    }
}

class XeMay extends PhuongTien{
    private int congXuatDongCo;
    public XeMay(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa,int congXuatDongCo) {
        super(ten, hangSanXuat, namSanXuat, vanTocToiDa);
        this.congXuatDongCo = congXuatDongCo;
        PhuongTien.soLuongPhuongTien++;
    }

    //impl hienThiThongTin()
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println(congXuatDongCo);
    }
}

public class Bai3 {
    public static void main(String[] args) {
        //fake input
        //bien trong stack         (vung nho trong heap)
        PhuongTien []arr = new PhuongTien[1000];
        PhuongTien xeMay1 = new XeMay("hoa","HonDa",2025,110,1000000);
        arr[PhuongTien.soLuongPhuongTien] = xeMay1;//arr[0] =
        PhuongTien xeMay2 = new XeMay("Hoaf","HonDa",2019,110,1000000);
        arr[PhuongTien.soLuongPhuongTien] = xeMay2;//arr[1] =
        PhuongTien oto1 = new Oto("hoamz","HonDa",2025,410,4,"Xang");
        arr[PhuongTien.soLuongPhuongTien] = oto1;//arr[2] =
        PhuongTien oto2 = new Oto("Hoamz","Mec",2025,500,7,"Dien");
        arr[PhuongTien.soLuongPhuongTien] = oto2;//arr[3] =

        //out put
        for(int i=0;i<=PhuongTien.soLuongPhuongTien;i++){
            arr[i].hienThiThongTin();
        }
    }
}
